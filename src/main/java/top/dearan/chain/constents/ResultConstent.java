package top.dearan.chain.constents;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:50
 */
public class ResultConstent {

    public static final String ACCOUNT_FROZEN = "账户处于被冻结状态，请通过online返至产品进行解冻";
    public static final String INSUFFICIENT_BALANCE= "账户余额不足，请充值";
    public static final String NOT_PROMOTION = "目前帖子处于未推广状态，无法定位问题，待帖子正常推广后返至排查工具进行排查";
    public static final String INSUFFICIENT_BUDGET = "帖子当前预算不充足无法定位问题，请确保帖子预算充足情况下进行工具排查";
    public static final String NOT_IN_PROMOTION_TIME = "帖子当前不在推广时间内，请确保问题排查时间在帖子的推广时间范围内进行工具排查";
    public static final String NOT_IN_CATE_LOCAL = "帖子在提供连接页面并未设置推广，请核实投放类目及区域";
    public static final String UNDER_BASEPRICE = "帖子出价低于最低展示价格，建议提高出价";
    public static final String UNDER_LAST_PRICE = "客户帖子出价低于最后一名帖子出价，建议提高出价";
    public static final String Q_LOW = "帖子质量度较低，建议客户对帖子的标题和内容等进行优化";
    public static final String MORE_THAN_THREE = "防霸屏策略原因导致不展示：由于该账户在类目及地域下推广帖子较多，一个账户在同一类目及地域下最多展示三条帖子";
    public static final String SIMILARITY = "该帖子于账户中的另一条帖子相似度较高，导致该帖子不展示，建议修改";
    public static final String NO_ISSUE = "经排查，帖子商业端无异常，请按照一下步骤进行核实，1.核实客户操作IP是否被排除 2.若为MOB端请核实是否为LBS策略导致 3.若依然存在问题，请返至产品进行排查";
}
