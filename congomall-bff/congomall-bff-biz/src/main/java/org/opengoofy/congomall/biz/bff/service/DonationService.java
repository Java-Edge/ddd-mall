

package org.opengoofy.congomall.biz.bff.service;

import org.opengoofy.congomall.biz.bff.common.PageAdapter;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.DonationAdapterRespDTO;
import org.opengoofy.congomall.biz.bff.dto.resp.adapter.HomePanelAdapterRespDTO;

import java.util.List;

/**
 * 捐赠接口层
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface DonationService {
    
    /**
     * 分页查询捐赠列表
     *
     * @param page 当前页
     * @param size 每页多少条
     * @return 返回捐赠列表
     */
    PageAdapter<List<DonationAdapterRespDTO>> pageQueryDonation(int page, int size);
    
    /**
     * 用户捐赠板块
     *
     * @return 捐赠板块返回数据
     */
    HomePanelAdapterRespDTO queryDonation();
}
