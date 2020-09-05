package org.buptdavid.datastructure.axALG;

public class Note {

    //5是障碍物
    private byte type;
    private byte id;// 区域ID
    private byte use;// 0:没用 1 被设为终点 2 被占用

    Note(byte type, byte id) {
        this.id = id;
        this.type = type;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getUse() {
        return use;
    }

    public void setUse(byte use) {
        this.use = use;
    }


    /**
     * 返回 false表示不可以通过
     *
     * @return
     */
    public Boolean checkXY() {
        return type != (byte) 5 && use != (byte) 2;
    }
}
