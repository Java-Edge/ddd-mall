

package org.opengoofy.congomall.biz.bff.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.opengoofy.congomall.biz.bff.common.PageAdapter;
import org.opengoofy.congomall.biz.bff.common.PayTypeEnum;
import org.opengoofy.congomall.biz.bff.dao.entity.DonationDO;
import org.opengoofy.congomall.biz.bff.dao.entity.PanelDO;
import org.opengoofy.congomall.biz.bff.dao.entity.PanelProductRelationDO;
import org.opengoofy.congomall.biz.bff.dao.mapper.DonationMapper;
import org.opengoofy.congomall.biz.bff.dao.mapper.PanelMapper;
import org.opengoofy.congomall.biz.bff.dao.mapper.PanelProductRelationMapper;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.DonationAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelContentAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.service.DonationService;
import org.opengoofy.congomall.biz.bff.remote.ProductRemoteService;
import org.opengoofy.congomall.biz.bff.remote.resp.ProductRespDTO;
import org.opengoofy.congomall.biz.bff.remote.resp.ProductSpuRespDTO;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 捐赠接口层实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {
    
    private final DonationMapper donationMapper;
    private final PanelMapper panelMapper;
    private final PanelProductRelationMapper panelProductRelationMapper;
    private final ProductRemoteService productRemoteService;
    
    @Override
    @Cached(name = "donation:", key = "'page-query-'+#page+'-'+#size", expire = 24, timeUnit = TimeUnit.HOURS)
    public PageAdapter<List<DonationAdapterRespDTO>> pageQueryDonation(int page, int size) {
        IPage<DonationDO> donationDOPage = donationMapper.selectPage(new Page<>(page, size), Wrappers.emptyWrapper());
        IPage<DonationAdapterRespDTO> resultPage = donationDOPage.convert(each -> {
            DonationAdapterRespDTO convert = BeanUtil.convert(each, DonationAdapterRespDTO.class);
            convert.setPayType(PayTypeEnum.getNameByCode(each.getPayType()));
            return convert;
        });
        PageAdapter pageAdapter = new PageAdapter();
        pageAdapter.setData(resultPage.getRecords());
        pageAdapter.setSuccess(true);
        pageAdapter.setDraw(0);
        pageAdapter.setRecordsFiltered(0);
        pageAdapter.setRecordsTotal(donationDOPage.getTotal());
        return pageAdapter;
    }
    
    @Override
    @Cached(name = "donation:", key = "'query'", expire = 24, timeUnit = TimeUnit.HOURS)
    public HomePanelAdapterRespDTO queryDonation() {
        PanelDO thank = panelMapper.getThank();
        HomePanelAdapterRespDTO result = BeanUtil.convert(thank, HomePanelAdapterRespDTO.class);
        List<PanelProductRelationDO> panelProductRelationList = panelProductRelationMapper.listPanelProductRelationByPanelId(thank.getId());
        if (CollUtil.isNotEmpty(panelProductRelationList)) {
            List<HomePanelContentAdapterRespDTO> panelContents = new ArrayList<>();
            panelProductRelationList.forEach(item -> {
                Result<ProductRespDTO> productResult = productRemoteService.getProductBySpuId(String.valueOf(item.getProductId()));
                if (productResult.isSuccess() && productResult.getData() != null) {
                    ProductRespDTO resultData = productResult.getData();
                    ProductSpuRespDTO productSpu = resultData.getProductSpu();
                    HomePanelContentAdapterRespDTO productRespDTO = new HomePanelContentAdapterRespDTO();
                    productRespDTO.setProductId(String.valueOf(productSpu.getId()));
                    productRespDTO.setProductName(productSpu.getName());
                    productRespDTO.setId(String.valueOf(productSpu.getId()));
                    productRespDTO.setSalePrice(productSpu.getPrice().intValue());
                    productRespDTO.setSortOrder(item.getSort());
                    productRespDTO.setSubTitle(productSpu.getSubTitle());
                    productRespDTO.setPanelId(thank.getId());
                    productRespDTO.setType(0);
                    productRespDTO.setCreated(new Date());
                    productRespDTO.setUpdated(new Date());
                    List<String> pics = StrUtil.split(productSpu.getPic(), ",");
                    if (pics.size() == 1) {
                        productRespDTO.setProductImageBig(pics.get(0));
                        productRespDTO.setPicUrl(pics.get(0));
                    }
                    panelContents.add(productRespDTO);
                }
            });
            result.setPanelContents(panelContents);
        }
        return result;
    }
}
