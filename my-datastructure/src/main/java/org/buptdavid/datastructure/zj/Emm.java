package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @EnumName: Emm
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2022/3/9/10:49
 */
public enum Emm {

    /**
     * 进阶比拼全服总榜
     */
    AdvanceCostAll(1001,1);


    private int id;
    private int rankSeviceType;

    Emm(int id,int rankSeviceType) {
        this.id = id;
        this.rankSeviceType=rankSeviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRankSeviceType() {
        return rankSeviceType;
    }

    public void setRankSeviceType(int rankSeviceType) {
        this.rankSeviceType = rankSeviceType;
    }
}
