package com.xks.parkjicha.controller;

import com.google.gson.Gson;
import com.xks.parkjicha.bean.*;
import com.xks.parkjicha.util.Code;
import com.xks.parkjicha.util.Msg;
import com.xks.parkjicha.util.UserMatcher;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Anxiaomo on 2016/11/14.
 */
@Controller
@Scope("prototype")
@RequestMapping("ETC/api.jicha")
public class JichaController {
    private static String token;
    private Logger logger = Logger.getLogger(JichaController.class);
    private static final int SUCCESS=1;

    private static final int FAILURE=0;
    /**
     * 登录
     * @param loginReqBean 登录
     * @return BaseBean
     */
    @RequestMapping(params = "method=login", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<LoginRspBean> login(@RequestBody LoginReqBean loginReqBean, HttpSession httpSession) {
        logger.info("\n\nloginReqBean:"+loginReqBean);
        BaseBean<LoginRspBean> baseBean =new BaseBean();
        try {
            ArrayList<BlockBean> blocks=new ArrayList<>();
            BlockBean b_1=new BlockBean("01","珞瑜路1037号",false);
            BlockBean b_2=new BlockBean("02","佳园路68号",false);
            BlockBean b_3=new BlockBean("03","武珞路69号",false);
            if (loginReqBean!=null&&loginReqBean.getWorkerid()!=null&&loginReqBean.getPassword()!=null){
                LoginRspBean loginRspBean=new LoginRspBean();
                if (UserMatcher.hasUser(loginReqBean)){
                    blocks.add(b_1);
                    blocks.add(b_2);
                    blocks.add(b_3);
                    token=getToken();
                    loginRspBean.setToken(token);
                    loginRspBean.setBlocks(blocks);
                    httpSession.setAttribute("workedid",loginReqBean.getWorkerid());
                    baseBean.setCode(Code.SUCCESS);
                    baseBean.setMsg(Msg.SUCCESS);
                    baseBean.setResult(SUCCESS);
                }else {
                    baseBean.setCode(Code.PWD_ERROR);
                    baseBean.setMsg(Msg.PWD_ERROR);
                    baseBean.setResult(FAILURE);
                }
                baseBean.setData(loginRspBean);
            }else {
                baseBean.setCode(Code.PARAM_NULL);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setResult(FAILURE);
            }
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nlogin baseBean:"+ baseBean);
        return baseBean;
    }
    /**
     * 选择稽查街区
     * @param chooseReqBean 稽查街区
     * @return BaseHttpBean
     */
    @RequestMapping(params = "method=choose", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<ChooseRspBean> choose(@RequestBody ChooseReqBean chooseReqBean){
        logger.info("\n\nchooseReqBean:"+chooseReqBean);
        BaseBean<ChooseRspBean> baseBean=new BaseBean<>();
        try {
            Gson gson=new Gson();
            String result=gson.toJson(chooseReqBean);
            chooseReqBean=gson.fromJson(result,ChooseReqBean.class);
            logger.info("chooseReqBean:"+chooseReqBean);
            if(chooseReqBean!=null&&chooseReqBean.getWorkerid()!=null&&chooseReqBean.getBlocks()!=null){
                ArrayList<String> blocks=chooseReqBean.getBlocks();
                ChooseRspBean chooseRspBean=new ChooseRspBean();
                chooseRspBean.setStatus("1");
                baseBean.setResult(SUCCESS);
                baseBean.setMsg(Msg.SUCCESS);
                baseBean.setCode(Code.SUCCESS);
                baseBean.setData(chooseRspBean);
            }else {
                baseBean.setCode(Code.PARAM_NULL);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setResult(FAILURE);

            }
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nchoose baseBean:"+baseBean);
        return baseBean;
    }
    /**
     * 轮询变化车位
     * @param plateReqBean
     * @return
     */
    @RequestMapping(params = "method=poll", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<PlateRspBean> poll(@RequestBody PlateReqBean plateReqBean){
        logger.info("\n\nplateReqBean:"+plateReqBean);
        long thistime=System.currentTimeMillis();
        long lasttime=plateReqBean.getLasttime();
        BaseBean<PlateRspBean> baseBean=new BaseBean<>();
        try {
            if(plateReqBean!=null){
                PlateRspBean plateRspBean=new PlateRspBean(thistime,getPlates());
                baseBean.setResult(SUCCESS);
                baseBean.setMsg(Msg.SUCCESS);
                baseBean.setCode(Code.SUCCESS);
                baseBean.setData(plateRspBean);
            }else {
                baseBean.setCode(Code.PARAM_NULL);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setResult(FAILURE);
            }

        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\npoll baseBean："+baseBean);
        return  baseBean;
    }

    /**
     * 查询欠费记录报文
     * @param queryReqBean 欠费
     * @return BaseHttpBean
     */
    @RequestMapping(params = "method=query", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<QueryRspBean> query(@RequestBody QueryReqBean queryReqBean){
        logger.info("\n\nqueryReqBean:"+queryReqBean);
        BaseBean<QueryRspBean> baseBean=new BaseBean<>();

        QueryRspBean queryRspBean=new QueryRspBean();

        try {
            if (queryReqBean!=null&&queryReqBean.getPlatenum()!=null){
                logger.info("查询欠费记录:"+queryReqBean);
                ArrayList<RecordBean> records=getRecords();
                int recordnum=records.size();
                queryRspBean.setRecordnum(recordnum);
                queryRspBean.setRecords(records);
                baseBean.setResult(SUCCESS);
                baseBean.setCode(Code.SUCCESS);
                baseBean.setMsg(Msg.SUCCESS);
                baseBean.setData(queryRspBean);
            }else {
                //查询欠费记录失败
                baseBean.setResult(FAILURE);
                baseBean.setCode(Code.PARAM_NULL);
                baseBean.setMsg(Msg.PARAM_NULL);
            }
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nquery baseHttpBean:"+baseBean);
        return baseBean;
    }
    /**
     * 生成欠费订单
     * @param mergeRecordReqBean 欠费订单
     * @return BaseBean
     */
    @RequestMapping(params = "method=bill", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<MergeRecordRspBean> bill(@RequestBody MergeRecordReqBean mergeRecordReqBean){
        logger.info("\n\nmergeRecordReqBean:"+mergeRecordReqBean);
        Gson gson=new Gson();
        String result=gson.toJson(mergeRecordReqBean);
        mergeRecordReqBean=gson.fromJson(result,MergeRecordReqBean.class);
        BaseBean<MergeRecordRspBean> baseBean =new BaseBean<>();

        try{
            if(mergeRecordReqBean!=null&&mergeRecordReqBean.getPlatenum()!=null&&mergeRecordReqBean.getRecords()!=null){
                ArrayList<RecordBean> records=mergeRecordReqBean.getRecords();
                int total=0;
                for(RecordBean record:records){
                    total=total+record.getArrearamount();
                }
                MergeRecordRspBean mergeRecordRspBean=new MergeRecordRspBean();
                if(mergeRecordReqBean.getRecords().size()!=0){
                    mergeRecordRspBean.setSerialNum("123011111");
                    mergeRecordRspBean.setTotal(total);
                    baseBean.setResult(SUCCESS);
                    baseBean.setMsg(Msg.SUCCESS);
                    baseBean.setCode(Code.SUCCESS);
                    baseBean.setData(mergeRecordRspBean);
                }
            }else {
                baseBean.setResult(FAILURE);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setCode(Code.PARAM_NULL);
            }
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nmergeRecord baseBean:"+ baseBean);
        return baseBean;
    }
    /**
     * 武汉通缴费
     * @param whtPayReqBean 武汉通缴费
     * @return BaseBean
     */
    @RequestMapping(params = "method=WHTpay", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<WhtPayResBean> WHTpay(@RequestBody WhtPayReqBean whtPayReqBean){
        logger.info("\n\nwhtPayReqBean:"+whtPayReqBean);
        BaseBean<WhtPayResBean> baseBean =new BaseBean<>();
        try {
            if(whtPayReqBean!=null&&whtPayReqBean.getDealauthcode()!=null&&whtPayReqBean.getDealtime()!=null
                    &&whtPayReqBean.getLastdealtime()!=null&&whtPayReqBean.getLastterminalnum()!=null
                    &&whtPayReqBean.getLogiccardnum()!=null&&whtPayReqBean.getOfflinetimes()!=null&&whtPayReqBean.getPhysiccardnum()!=null
                    &&whtPayReqBean.getOnlinetimes()!=null&&whtPayReqBean.getPlatinum()!=null&&whtPayReqBean.getSerialnum()!=null
                    &&whtPayReqBean.getTerminalnum()!=null&&whtPayReqBean.getTerminalserialnum()!=null){
                WhtPayResBean whtPayResBean=new WhtPayResBean();
                if(whtPayReqBean.getDealamount()>whtPayReqBean.getBalance()){
                    whtPayResBean.setStatus("1");
                    baseBean.setCode(Code.SUCCESS);
                    baseBean.setMsg(Msg.SUCCESS);
                    baseBean.setResult(SUCCESS);
                    baseBean.setData(whtPayResBean);
                }else {
                    baseBean.setResult(FAILURE);
                    baseBean.setMsg(Msg.INSUFFICIENT_BALANCE);
                    baseBean.setCode(Code.INSUFFICIENT_BALANCE);
                }


            }else {
                baseBean.setResult(FAILURE);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setCode(Code.PARAM_NULL);
            }

        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nwhtPay baseBean:"+ baseBean);
        return baseBean;
    }

    /**
     * 银联卡缴费
     * @param unionPayReqBean 银联卡缴费
     * @return BaseBean
     */
    @RequestMapping(params = "method=UnionPay", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<UnionPayResBean> UnionPay(@RequestBody UnionPayReqBean unionPayReqBean){
        logger.info("\n\nunionPayReqBean:"+unionPayReqBean);
        BaseBean<UnionPayResBean> baseBean =new BaseBean<>();
        try {
            if(unionPayReqBean!=null&&unionPayReqBean.getUserid()!=null&&unionPayReqBean.getStatus()!=null
                    &&unionPayReqBean.getCardid()!=null&&unionPayReqBean.getBatchnum()!=null) {

                if(unionPayReqBean.getRealamount()<500000){
                    UnionPayResBean unionPayResBean = new UnionPayResBean();
                    unionPayResBean.setStatus("1");
                    baseBean.setCode(Code.SUCCESS);
                    baseBean.setMsg(Msg.SUCCESS);
                    baseBean.setResult(SUCCESS);
                    baseBean.setData(unionPayResBean);
                }else {
                    baseBean.setResult(FAILURE);
                    baseBean.setMsg(Msg.PARAM_NULL);
                    baseBean.setCode(Code.PARAM_NULL);
                }
            }else {
                baseBean.setResult(FAILURE);
                baseBean.setMsg(Msg.PARAM_NULL);
                baseBean.setCode(Code.PARAM_NULL);
            }
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nunionPay baseBean:"+ baseBean);
        return baseBean;
    }
    @RequestMapping(params = "method=version", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<VersionBean> getVersion(){
        BaseBean<VersionBean> baseBean=new BaseBean<>();
        try {
            VersionBean versionBean=new VersionBean("02","jicha","更新","www.baidu","2016-11-14 00:00:00","an",false);
            baseBean.setCode(Code.SUCCESS);
            baseBean.setMsg(Msg.SUCCESS);
            baseBean.setResult(SUCCESS);
            baseBean.setData(versionBean);
        }catch (Exception e){
            baseBean.setCode(Code.SYSTEM_ERROR);
            baseBean.setMsg(Msg.SYSTEM_ERROR);
            baseBean.setResult(FAILURE);
            logger.error(e);
        }
        logger.info("\n\nversion baseBean:"+baseBean);
        return baseBean;
    }


    /**
     * 获取token
     * @return
     */
    private String getToken() {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){
            int number=(int)(Math.random()*62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取车位变化列表
     * @return
     */
    private ArrayList<PlateBean> getPlates(){
        Random ra =new Random();
        int number = ra.nextInt(10)+1;
        ArrayList<PlateBean> plates=new ArrayList<>();
       /* Date d = new Date(lastTime);*/
        for(int i=1;i<number;i++){
            /*车牌号*/
            String str="0123456789";
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<5;j++){
                int number1=ra.nextInt(10);
                sb.append(str.charAt(number1));
            }
            String platenum="鄂A"+sb.toString();
            /*车牌颜色*/
            byte platecolor=(byte)ra.nextInt(4);
            String block="鲁磨路"+i+"号";
            String parknum=""+i;
            double X=60.1+i*0.1;
            double Y=30.1+i*0.1;
            boolean flag=false;
            if (i%2==0){
                flag=true;
            }
            PlateBean plateBean=new PlateBean(platenum,platecolor,block,parknum,X,Y,flag);
            plates.add(plateBean);
        }

        return plates;
    }
    private ArrayList<RecordBean> getRecords(){
        ArrayList<RecordBean> records=new ArrayList<>();
        for (int i=0;i<10;i++){
            long timein=System.currentTimeMillis();
            Date d = new Date(timein);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.HOUR, i);
            long timeleave=c.getTimeInMillis();
            String arreartype="1";
            if (i%2==0){
                arreartype="2";
            }
            RecordBean recordBean=new RecordBean(i+""+System.currentTimeMillis(),arreartype,"鲁磨路"+i+"号","1"+i*i, timein, timeleave,20+i*2,10+i*3,5+3*i,i+50);
            System.out.println();
            records.add(recordBean);
        }
        return records;
    }
}
