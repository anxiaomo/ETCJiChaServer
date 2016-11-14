package com.xks.parkjicha.bean;

/**
 * Created by Administrator on 2016/9/17.
 */
public class BlockBean
{
    private String blockid;

    private String blockname;

    private boolean flag;

    public BlockBean(String blockid, String blockname, boolean flag) {
        this.blockid = blockid;
        this.blockname = blockname;
        this.flag = flag;
    }

    public BlockBean(String blockid, String blockname) {
        this.blockid = blockid;
        this.blockname = blockname;
    }

    public String getBlockid() {
        return blockid;
    }

    public String getBlockname() {
        return blockname;
    }

    public boolean isFlag() {
        return flag;
    }


    public void setBlockid(String blockid) {
        this.blockid = blockid;
    }

    public void setBlockname(String blockname) {
        this.blockname = blockname;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BlockBean{" +
                "blockid='" + blockid + '\'' +
                ", blockname='" + blockname + '\'' +
                ", flag=" + flag +
                '}';
    }
}
