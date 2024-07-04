

package org.opengoofy.congomall.mybatisplus.springboot.starter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.opengoofy.congomall.springboot.starter.common.toolkit.BeanUtil;
import org.opengoofy.congomall.springboot.starter.convention.page.PageRequest;
import org.opengoofy.congomall.springboot.starter.convention.page.PageResponse;

/**
 * 分页工具类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class PageUtil {
    
    /**
     * {@link PageRequest} to {@link Page}
     *
     * @param pageRequest
     * @return
     */
    public static Page convert(PageRequest pageRequest) {
        return convert(pageRequest.getCurrent(), pageRequest.getSize());
    }
    
    /**
     * {@link PageRequest} to {@link Page}
     *
     * @param current
     * @param size
     * @return
     */
    public static Page convert(long current, long size) {
        return new Page(current, size);
    }
    
    /**
     * {@link IPage} to {@link PageRequest}
     *
     * @param iPage
     * @return
     */
    public static PageResponse convert(IPage iPage) {
        return buildConventionPage(iPage);
    }
    
    /**
     * {@link IPage} to {@link PageRequest}
     *
     * @param iPage
     * @param targetClass
     * @param <TARGET>
     * @param <ORIGINAL>
     * @return
     */
    public static <TARGET, ORIGINAL> PageResponse<TARGET> convert(IPage<ORIGINAL> iPage, Class<TARGET> targetClass) {
        iPage.convert(each -> BeanUtil.convert(each, targetClass));
        return buildConventionPage(iPage);
    }
    
    /**
     * {@link IPage} build to {@link PageRequest}
     *
     * @param iPage
     * @return
     */
    private static PageResponse buildConventionPage(IPage iPage) {
        return PageResponse.builder().current(iPage.getCurrent()).size(iPage.getSize()).records(iPage.getRecords()).total(iPage.getTotal()).build();
    }
}
