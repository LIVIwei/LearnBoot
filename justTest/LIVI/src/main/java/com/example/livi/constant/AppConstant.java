package com.example.livi.constant;

import com.example.livi.enums.EnvironmentEmum;

public class AppConstant {
    public static final String DCEP_HEAD = "dcepHead";
    public static final String DCEP_BODY = "body";
    public static final String MSG_TYPE = "MesgType";
    public static final String SM3 = "SM3";
    //BCM 直连
    public static final String BCM_HEAD = "bcmHead";
    public static final String BCM_BODY = "body";
    //手机银行对外
    public static final String MOBILE_HEAD = "head";
    public static final String MOBILE_BODY = "body";

    /**
     * 发送消息最大长度限制
     */
    public static final Integer MESSAGE_SIZE                 =1024;          //消息大小


    /**
     * 行内系统标识
     */
    public static final String ECNY_SYS_ID                   = "ECNY";       //支付子应用
    public static final String COP_SYS_ID                    = "COP";        //金融开放平台
    public static final String CORE_SYS_ID                   = "CRPM";       //银行核心
    public static final String BDRD_SYS_ID                   = "BDRD";       //大数据零售智能风控子应用
    public static final String ECIF_SYS_ID                   = "ECIF";       //ECIF
    public static final String BCM_SYS_ID                    = "BCM";        //交通银行
    public static final String BOC_SYS_ID                    = "BOC";        //中国银行
    public static final String CIB_SYS_ID                    = "CIB";        //兴业银行
    public static final String COUNTER_SYS_ID                = "CNT";        //柜面系统

   //金华银行 数币记账渠道区分：prodcode 产品代码：
    public static final String DCEP_CORE_ID                   = "DCEP";       //城银清
    public static final String BCM0_CORE_ID                   = "BCM0";       //交通银行(个人钱包)
    public static final String BOC0_CORE_ID                   = "BOC0";       //中国银行(个人钱包)
    public static final String BCM1_CORE_ID                   = "BCM1";       //交通银行(对公钱包)
    public static final String BOC1_CORE_ID                   = "BOC1";       //中国银行(对公钱包)
  //金华银行 手机银行对外head
    public static final String MOBILE_HEAD_ID                 = "1005";       //渠道id，默认配置1005
    public static final String MOBILE_HEAD_FROM                = "8";       //三方系统代码 8:数币系统


    /**
     * 外部系统标识
     */
    public static final String UWAP_SYS_ID                   = "UWAP";       //数字钱包
    public static final String DCEP_SYS_ID                   = "DCEP";       //互联互通
    public static final String DCPS_SYS_ID                   = "DCPS";       //城银清

    /**
     * 金融机构编码      C1030644021075
     */

//    public static final String BANK_FINANCIAL_INSTITUTION_CD = "C1092633000023";//"C1092633000023";        //本行机构号
//    public static final String DCEP_FINANCIAL_INSTITUTION_CD = "G4001011000013"; //  G4001011000013(互联互通平台（数研所）)
//    public static final String DCPS_FINANCIAL_INSTITUTION_CD = "G4000131000016";// G4000131000016 城银清算   //运营机构号  C1030131001288
//
//    public static final String INST_FINANCIAL_INSTITUTION_CD = "C1030131001288";//运营机构号  C1030131001288
    /**
     * 改造查询数据库
     * @return
     */
    //本行
   //  public static String getBankFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","BANK_FINANCIAL_INSTITUTION_CD","C1092633000023");
   //  }
   //  //互联互通
   //  public static String getDcepFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","DCEP_FINANCIAL_INSTITUTION_CD","G4001011000013");
   //  }
   // //城银清算
   //  public static String getDcpsFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","DCPS_FINANCIAL_INSTITUTION_CD","G4000131000016");
   //  }
   //  //运营机构（交通银行股份有限公司）
   //  public static String getINSTFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","INST_FINANCIAL_INSTITUTION_CD","C1030131001288");
   //  }
   //  //运营机构（中国银行）
   //  public static String getBOCFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","FINANCIAL_INSTITUTION_BOC","C1010411000013");
   //  }
   //  //运营机构（兴业银行）
   //  public static String getCIBFinancialInstitutionCd(){
   //      return PayCommonParamConf.getPayCommParamVal("1","FINANCIAL_INSTITUTION_CIB","C1030935001347");
   //  }

    public static final String ORGCODE = "106";

    public static final String APP_ID = "app201901170913";
    //金华银行机构代码
    public static final String JHBANK_ORG_CODE = "300300C1092633000074";

    //预留机构代码
    public static final String ORG_CODE = "300300C1092633000074";
    /**
     * 交易类别
     */
    public static final String TXN_TYPE_SIGN = "S";     // 签约类
    public static final String TXN_TYPE_COMM = "C";     // 通用类
    public static final String TXN_TYPE_CAPITAL = "F";  // 资金类
    /**
     * 签约类型
     */
    public static final String SIGN_TYPE_DECP = "D";     // 通过城银清签约
    public static final String SIGN_TYPE_BCM = "M";      // 通过交通银行签约
    public static final String SIGN_TYPE_BOC = "C";      // 通过中国银行签约

    /**
     * 业务状态
     */
    public static final String TRXSTATUS_SUCCESS                   = "1";       //成功
    public static final String TRXSTATUS_FAILED                    = "0";       //失败
    public static final String TRXSTATUS_ABEND                     = "2";       //异常
    public static final String TRXSTATUS_REVERSED                  = "3";       //已冲正
    public static final String TRXSTATUS_RETURNED                  = "5";       //已退回
    public static final String TRXSTATUS_RECIPE                    = "7";       //已收妥
    public static final String TRXSTATUS_UNDO                      = "8";       //已撤销
    public static final String TRXSTATUS_INIT                      = "9";       //未处理
    public static final String TRXSTATUS_PRECREDITSUCCESS          = "A";       //801调账处理状态
    public static final String TRXSTATUS_HIDE_DONE                 = "B";       //隔天冲正失败失败，已处理状态
    public static final String PAYPATHSTATUS_MSG_VERIFY = "M";       //短信验证

    /**
     * 业务处理码
     */
    public static final String TRX_RET_CODE_SUCCESS                = "ECNY000000";       //成功
    public static final String TRX_RET_CODE_FAILED                 = "ECNY000001";       //失败
    public static final String TRX_RET_CODE_PROCESSING             = "ECNY000002";       //处理中

    /**
     * 业务处理信息
     */
    public static final String TRX_RET_MSG_SUCCESS                 = "SUCCESS";          //成功
    public static final String TRX_RET_MSG_FAILED                  = "FAILED";           //失败
    public static final String TRX_RET_MSG_PROCESSING              = "PROCESSING";       //处理中

    /**
     * 核心状态
     */
    public static final String CORESTATUS_INIT                     = "9";       //未处理
    public static final String CORESTATUS_SUCCESS                  = "1";       //成功
    public static final String CORESTATUS_FAILED                   = "0";       //失败
    public static final String CORESTATUS_ABEND                    = "2";       //异常
    public static final String CORESTATUS_REVERSED                 = "3";       //已冲正
    public static final String CORESTATUS_REVERSING                = "4";       //正在冲正
    public static final String CORESTATUS_TRANSFER                 = "5";       //已划转
    public static final String CORESTATUS_TRANSFING                = "6";       //正在划转
    public static final String CORESTATUS_FREEZE                   = "7";       //已冻结
    public static final String CORESTATUS_UNFREEZE                 = "8";       //已解冻
    public static final String CORESTATUS_PRECREDITSUCCESS         = "A";       //预入账成功


    /**
     * 通道状态
     */
    public static final String PAYPATHSTATUS_SUCCESS               = "1";       //成功
    public static final String PAYPATHSTATUS_FAILED                = "0";      //失败
    public static final String PAYPATHSTATUS_ABEND                 = "2";      //异常
    public static final String PAYPATHSTATUS_REVERSED              = "3";      //已冲正
    public static final String PAYPATHSTATUS_REVERSING             = "4";      //正在冲正
    public static final String PAYPATHSTATUS_RETURNED              = "5";      //已退回
    public static final String PAYPATHSTATUS_RETURNING             = "6";      //正在退回
    public static final String PAYPATHSTATUS_RECIPE                = "7";      //已收妥
    public static final String PAYPATHSTATUS_RSPFAILD              = "8";      //回执失败
    public static final String PAYPATHSTATUS_INIT                  = "9";      //未处理
    public static final String PAYPATHSTATUS_RSPSUCCESS            = "A";      //回执成功


    /**
     * 往来方向
     */
    public static final String DIRECT_SEND	= "S";
    public static final String DIRECT_RECV	= "R";

    /**
     * [人名币]往来方向
     */
    public static final String DCWLT_DIRECT_SEND	= "U";
    public static final String DCWLT_DIRECT_RECV	= "D";


    /**
     * 收付标识
     */
    public static final String IDENTIFICATION_PAYEE = "PAYEE";
    public static final String IDENTIFICATION_PAYER = "PAYER";

    /**
     * 协议状态 N：签约状态   C：解约状态
     */
    public static final String SIGN_STATUS_NORMAL = "N";
    public static final String SIGN_STATUS_CLOSE  = "C";

    /**
     * 异常事件重试标识
     */
    public static final String EVENT_AGAIN_Y                      = "Y";       //重试
    public static final String EVENT_AGAIN_N                      = "N";

     /**
     * 生效状态标识
     */
    public static final String EFFECTIVE_STATUS_EFFECTIVE   = "1";              //生效中
    public static final String EFFECTIVE_STATUS_REVOKE      = "0";              //已撤销

    /**
     * 操作步骤
     */
    public static final String OPERSTEP_INIT                = "INIT";           //入库
    public static final String OPERSTEP_DRDT                = "DRDT";           //扣账
    public static final String OPERSTEP_CRDT                = "CRDT";           //入账
    public static final String OPERSTEP_REVR                = "REVR";           //冲正

    /**
     * 操作状态
     */
    public static final String OPERSTATUS_SUCC              = "SUCC";           //成功
    public static final String OPERSTATUS_FAIL              = "FAIL";           //失败
    public static final String OPERSTATUS_EXPT              = "EXPT";           //异常

    public static final String CURRENCY_SYMBOL              = "CNY";            //币种

    /**
     * 操作状态
     */
    public static final String SEND_STATUS_ZERO              = "0";           //未发送
    public static final String SEND_STATUS_ONE               = "1";           //成功
    public static final String SEND_STATUS_TWO               = "2";           //失败
    /**
     * 接收超时时间
     */
    public static final long REQUEST_READ_TIMEOUT = 3000L;

    /**
     * 当前环境
     */
    public static final EnvironmentEmum ENVIRONMENT_EMUM =  EnvironmentEmum.DEV;

    /*
    * 自定义错误信息
    * */
    public static final String FAULT_MSG = "报文处理失败";

    /**
     * TR00100250个人客户基本信息查询交易（定长）
     */

    public static final String ENCODE_GBK = "gbk";

    public static final String REQ_ECIF   = "ECIF";

    public static final String ECIF_SRVCODE_TR00100250_GATEWAY = "EC0004";

    public static final String ECIF_SERV_SUCC = "CII0000000";

    public static final String ECIF_SERV_SUCC1 = "CII0000001";

    public static final String ECIF_SRVCODE_TR00100250 = "TR00100250";

    public static final String ECIF_QUERY_FAIL_MSG = "没有查询到符合条件的信息!";

    public static final String SYSTEMID = "ECNY";

    public static final String EFIC_DEFAULT_CHANNEL_NO = "100200000072";

    /**
     * TR00100300个人客户基本信息查询交易
     */
    public static final String ECIF_SRVCODE_TR00100300 = "TR00100300";
    public static final String ECIF_SRVCODE_TR00100300_GATEWAY = "EC0001";

    /**
     * ECIF 配置的源系统代码
     */
    public static final String ECIF_SOURCE_BRANCH_NO = "000147";
    public static final String ECIF_DEST_BRANCH_NO = "000042";

    /**
     * 业务类型 兑回、兑出、差错贷记调账
     */
    public static final String BUSINESS_TYPE_RECONVERT = "C201";
    public static final String BUSINESS_TYPE_CONVERT = "D201";
    public static final String BUSINESS_TYPE_DSPT = "E100";
    public static final String BUSINESS_TYPE_TRANSFER = "C202"; //实时贷记业务-付款
    public static final String BUSINESS_KIND_CONVERT_OFFICIAL = "03013";//兑回对公账户
    public static final String BUSINESS_KIND_RECONVERT_OFFICIAL = "03003";//兑出对公账户
    public static final String BUSINESS_KIND_TRANSFER_OFFICIAL = "02044";//付款

    /**
     * 反洗钱错误码
     */
    public static final String LSFK43_ACCOUNT_ERROR = "CB520012";
    public static final String LSFK43_ACCOUNT_AUTH_ERROR = "CB1010";

    /**
     * 0、未申请  1、 出入库重发，2、核心状态同步 3、手工冲账
     */
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TOW = 2;
    public static final Integer THR = 3;

    /**
     * 通用标签
     */
    public static final String PAYEE_AMOUNT = "_payeeAmount";       //兑回标签，日累计兑回限额标记用
    public static final String PAYER_AMOUNT = "_payerAmount";       //兑出标签，日累计兑出限额标记用

    /**
     * 生成message id标示
     */
    public static final String JHBANK_MSG_TYPE_PERSON_BCM = "JHP";       //金华银行对私message id 类型 （交行）
    public static final String JHBANK_MSG_TYPE_CORPORATE_BCM = "JHC";       //金华银行对公message id 类型 （交行）
    public static final String JHBANK_MSG_TYPE_MERCHANT_BCM = "JHM";       //金华银行对公message id 类型 （交行收单）
    public static final String JHBANK_MSG_TYPE_PERSON_BOC = "JHB";       //金华银行对私message id 类型 （中行）
    public static final String JHBANK_MSG_TYPE_CORPORATE_BOC = "JHO";       //金华银行对公message id 类型 （中行）

    /**
     * 交行代发分配给交行的6位机构代码
     */
    public static final String JHBANK_AGENCY_PAY_ORGNO = "000013";

    /**
     * 兴业银行分发至我行的银行机构编码
     */
    public static final String CIB_BANKORG = "XXXXXXXXXXX";//运营机构号
}
