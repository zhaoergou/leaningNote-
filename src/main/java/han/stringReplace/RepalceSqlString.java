/**
 * @FileName: RepalceSqlString.java
 * @creator zhaohanyang
 * @date Dec 3, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.stringReplace;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.text.WordUtils;

/**
 * @ClassName: RepalceSqlString
 * @Description: 
 * @author zhaohanyang
 * @date Dec 3, 2020
 * @version V1.0
 */
public class RepalceSqlString {
	
	
	private static String replaceSql(StringBuilder sql) {
		int flagStar = 0;
		int flag =0;

		while (-1!=sql.indexOf("beizhu.",flag)) {
			flagStar = sql.indexOf("beizhu.",flag);
			flag = flagStar +7;
			while((sql.charAt(flag)>=65 && sql.charAt(flag)<=90)||(sql.charAt(flag)>=97 && sql.charAt(flag)<=122)||(sql.charAt(flag)>=48 && sql.charAt(flag)<=57)) {
				flag++;
			}
			sql.insert(flag, "'");
		}
		
		
		return sql.toString().replaceAll("beizhu.", "beizhu ->> '");
		
	}

	 //(sql[flag+7]>=65 && sql[flag+7]<=90)||(sql[flag+7]>=97 && sql[flag+7]<=122)
	public static void main(String[] args) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"/**\r\n" + 
				" * @FileName: PbDfzjlsService.java\r\n" + 
				" * @creator zhaohanyang\r\n" + 
				" * @date Sep 10, 2020\r\n" + 
				" * @editor\r\n" + 
				" * @Description: \r\n" + 
				" * @version V1.0\r\n" + 
				" */\r\n" + 
				"package com.shineyue.dfjzls.service;\r\n" + 
				"\r\n" + 
				"import com.alibaba.fastjson.JSON;\r\n" + 
				"import com.alibaba.fastjson.JSONObject;\r\n" + 
				"import com.shineyue.bean.SupplementaryInfo;\r\n" + 
				"import com.shineyue.bean.project.Project;\r\n" + 
				"import com.shineyue.bean.project.ProjectProcessInfo;\r\n" + 
				"import com.shineyue.calldb.util.bean.DataResult;\r\n" + 
				"import com.shineyue.dfjzls.bean.PbDfzjlsDto;\r\n" + 
				"import com.shineyue.dfjzls.bean.PbDfzjlsCxDto;\r\n" + 
				"import com.shineyue.dfjzls.utils.PbDfzjlsConstants;\r\n" + 
				"import com.shineyue.pbcommon.bean.PbCommonDto;\r\n" + 
				"import com.shineyue.pbcommon.utils.CommonPorcessUtils;\r\n" + 
				"import com.shineyue.pbcommon.utils.ConstantPool;\r\n" + 
				"import com.shineyue.pbcommon.utils.ObjectUtil;\r\n" + 
				"import com.shineyue.pbcommon.utils.PbHttpService;\r\n" + 
				"import com.shineyue.pbcommon.utils.PbResourceConfig;\r\n" + 
				"import com.shineyue.tools.SYJson;\r\n" + 
				"import lombok.extern.slf4j.Slf4j;\r\n" + 
				"import org.apache.commons.lang.StringUtils;\r\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
				"import org.springframework.stereotype.Service;\r\n" + 
				"import org.springframework.web.bind.annotation.RequestHeader;\r\n" + 
				"\r\n" + 
				"import java.util.ArrayList;\r\n" + 
				"import java.util.HashMap;\r\n" + 
				"import java.util.List;\r\n" + 
				"import java.util.Map;\r\n" + 
				"\r\n" + 
				"/**\r\n" + 
				" * @ClassName: PbDfzjlsService\r\n" + 
				" * @Description: \r\n" + 
				" * @author zhaohanyang\r\n" + 
				" * @date Sep 10, 2020\r\n" + 
				" * @version V1.0\r\n" + 
				" */\r\n" + 
				"@Service\r\n" + 
				"@Slf4j\r\n" + 
				"public class PbDfzjlsService {\r\n" + 
				"\r\n" + 
				"	@Autowired\r\n" + 
				"	SYJson syJson;\r\n" + 
				"	@Autowired\r\n" + 
				"	PbResourceConfig pbResourceConfig;\r\n" + 
				"\r\n" + 
				"	@Autowired\r\n" + 
				"	private CommonPorcessUtils commonPorcessUtils;\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * 党费资金流水流程\r\n" + 
				"	 * @param pbDfzjlsDto\r\n" + 
				"	 * @param headermap\r\n" + 
				"	 * @return\r\n" + 
				"	 */\r\n" + 
				"	public JSONObject capitalFlowExecute(PbDfzjlsDto pbDfzjlsDto, @RequestHeader Map<String, String> headermap)\r\n" + 
				"			throws Exception {\r\n" + 
				"		JSONObject httpResult = new JSONObject();\r\n" + 
				"		JSONObject params = new JSONObject();\r\n" + 
				"		String result = \"\";\r\n" + 
				"		try {\r\n" + 
				"			Map<String, Object> map = new HashMap<String, Object>(3);\r\n" + 
				"			// 新增时bpid,ywlsh校验\r\n" + 
				"			if (null != pbDfzjlsDto.getGcid() && 0 == pbDfzjlsDto.getGcid() && 1 == pbDfzjlsDto.getFssl()) {\r\n" + 
				"				if (listCapitalFlowByBpmid(pbDfzjlsDto) > 0) {\r\n" + 
				"					httpResult.put(\"success\", false);\r\n" + 
				"					httpResult.put(\"msg\", \"bpmid或ywlsh重复！\");\r\n" + 
				"					return httpResult;\r\n" + 
				"				}\r\n" + 
				"			}\r\n" + 
				"			PbCommonDto commonBean = ObjectUtil.parsePojo(pbDfzjlsDto, PbCommonDto.class);\r\n" + 
				"			// 获取封装公共流程参数\r\n" + 
				"			commonBean.setComment(\"【同意】\");\r\n" + 
				"			JSONObject bpmParams = commonPorcessUtils.getBpmParams1(commonBean);\r\n" + 
				"			// 增加自己流程参数\r\n" + 
				"			bpmParams.put(\"processKey\", PbDfzjlsConstants.Processkey.DFZJLS);\r\n" + 
				"			bpmParams.put(\"description\", pbDfzjlsDto.getDescription());\r\n" + 
				"			// 规则参数\r\n" + 
				"			JSONObject jsruleParams = new JSONObject();\r\n" + 
				"			// 拼接业务数据\r\n" + 
				"			JSONObject ywsj = getBusinessData(pbDfzjlsDto);\r\n" + 
				"			params.put(\"ywsj\", ywsj);\r\n" + 
				"			map.put(\"bpmParam\", bpmParams.toString());\r\n" + 
				"			map.put(\"businessParam\", params.toString());\r\n" + 
				"			map.put(\"ruleParam\", jsruleParams.toString());\r\n" + 
				"			JSONObject obj = new JSONObject();\r\n" + 
				"			obj.put(\"map\", map);\r\n" + 
				"			result = PbHttpService.doPostHeader(pbResourceConfig.getPtUrl() + ConstantPool.PlatformApi.Bpm.BPM,\r\n" + 
				"					obj.toString(), headermap);\r\n" + 
				"			if (result != null && ConstantPool.Jsonstr.QUOTES.equals(result.substring(0, 1))) {\r\n" + 
				"				result = result.substring(1, result.length() - 1).replace(ConstantPool.Jsonstr.BACKSLASH,\r\n" + 
				"						ConstantPool.Jsonstr.EMPTY);\r\n" + 
				"			}\r\n" + 
				"			httpResult = JSONObject.parseObject(result);\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			log.error(\"党费资金流水流程发起失败：\" + e.getMessage(), e);\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return httpResult;\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * 业务数据拼接\r\n" + 
				"	 * @param dto\r\n" + 
				"	 * @return\r\n" + 
				"	 * @throws Exception\r\n" + 
				"	 */\r\n" + 
				"	public JSONObject getBusinessData(PbDfzjlsDto dto) throws Exception {\r\n" + 
				"		JSONObject ywsjJson = null;\r\n" + 
				"		try {\r\n" + 
				"			dto.setDxbh(dto.getGrbh());\r\n" + 
				"			ywsjJson = new JSONObject();\r\n" + 
				"			Project project = new Project();\r\n" + 
				"			// pt_xmgc表信息\r\n" + 
				"			ProjectProcessInfo projectProcessInfo = new ProjectProcessInfo();\r\n" + 
				"			List<ProjectProcessInfo> listProjectProcessInfo = new ArrayList<ProjectProcessInfo>();\r\n" + 
				"			// pt_xmgc——bc备注信息\r\n" + 
				"			List<SupplementaryInfo> listSupplementaryInfo = new ArrayList<SupplementaryInfo>();\r\n" + 
				"			SupplementaryInfo supplementaryInfo = new SupplementaryInfo();\r\n" + 
				"			// 项目备注信息\r\n" + 
				"			JSONObject xmbzJson = new JSONObject();\r\n" + 
				"			xmbzJson.put(\"bdlx\", dto.getBdlx());\r\n" + 
				"			xmbzJson.put(\"bz\", dto.getBz());\r\n" + 
				"			xmbzJson.put(\"sqr\", dto.getSqr());\r\n" + 
				"			xmbzJson.put(\"syje\", dto.getSyje());\r\n" + 
				"			xmbzJson.put(\"sqrZzmm\", dto.getSqrZzmm());\r\n" + 
				"			xmbzJson.put(\"sqrbh\", dto.getSqrbh());\r\n" + 
				"			xmbzJson.put(\"sqrBmid\", dto.getSqrBmid());\r\n" + 
				"			xmbzJson.put(\"sqrTxdz\", dto.getSqrTxdz());\r\n" + 
				"			xmbzJson.put(\"sqrBmmc\", dto.getSqrBmmc());\r\n" + 
				"			xmbzJson.put(\"sqrDlwz\", dto.getSqrDlwz());\r\n" + 
				"			xmbzJson.put(\"xmlb\", dto.getXmlb());\r\n" + 
				"			xmbzJson.put(\"xmmc\", dto.getXmmc());\r\n" + 
				"			xmbzJson.put(\"dxbm\", dto.getSqrBmbh());\r\n" + 
				"			xmbzJson.put(\"lrsj\", dto.getLrsj());\r\n" + 
				"			supplementaryInfo.setBzlb(PbDfzjlsConstants.Bzlb.ZYW);\r\n" + 
				"			supplementaryInfo.setBeizhu(xmbzJson.toString());\r\n" + 
				"			// ???????????\r\n" + 
				"			supplementaryInfo.setBzid(null == dto.getBzid() ? 0 : dto.getBzid());\r\n" + 
				"			listSupplementaryInfo.add(supplementaryInfo);\r\n" + 
				"			// 放入补充信息\r\n" + 
				"			projectProcessInfo.setBcxx(listSupplementaryInfo);\r\n" + 
				"			projectProcessInfo.setSpzt(dto.getSpzt());\r\n" + 
				"\r\n" + 
				"			projectProcessInfo.setCgwbh(ConstantPool.Jsonstr.SPACE);\r\n" + 
				"			projectProcessInfo.setHbzl(ConstantPool.Jsonstr.SPACE);\r\n" + 
				"			// 发生金额，变动金额，\r\n" + 
				"			projectProcessInfo.setFsje(dto.getFsje());\r\n" + 
				"			projectProcessInfo.setFssl(dto.getFssl());\r\n" + 
				"			projectProcessInfo.setHfgs(0.0);\r\n" + 
				"			projectProcessInfo.setCgwbh(ConstantPool.Jsonstr.SPACE);\r\n" + 
				"			projectProcessInfo.setCgwms(ConstantPool.Jsonstr.SPACE);\r\n" + 
				"			projectProcessInfo.setDxbh(dto.getDxbh());\r\n" + 
				"			projectProcessInfo.setDxbm(ConstantPool.Dxbm.PERSONAL);\r\n" + 
				"			projectProcessInfo.setBlqd(dto.getBlqd());\r\n" + 
				"			projectProcessInfo.setBpmid(dto.getBpmid());\r\n" + 
				"			projectProcessInfo.setJgbh(dto.getJgbh());\r\n" + 
				"			projectProcessInfo.setUserid(dto.getUserid());\r\n" + 
				"			projectProcessInfo.setYwlsh(dto.getYwlsh());\r\n" + 
				"			projectProcessInfo.setLrczyid(dto.getUserid());\r\n" + 
				"			projectProcessInfo.setXmbh(dto.getXmbh());\r\n" + 
				"			projectProcessInfo.setFsdd(dto.getFsdd());\r\n" + 
				"			projectProcessInfo.setSxbm(PbDfzjlsConstants.SXBM);\r\n" + 
				"			projectProcessInfo.setGcid(null == dto.getGcid() ? 0 : dto.getGcid());\r\n" + 
				"			listProjectProcessInfo.add(projectProcessInfo);\r\n" + 
				"			// 放入备注信息\r\n" + 
				"			project.setProjectProcessInfo(listProjectProcessInfo);\r\n" + 
				"			ywsjJson = JSON.parseObject(JSON.toJSONString(project));\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			// TODO: handle exception\r\n" + 
				"			log.error(\"业务数据拼接错误：\" + e.getMessage(), e);\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return ywsjJson;\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * bpmid,ywlsh校验\r\n" + 
				"	 *\r\n" + 
				"	 * @return bpmid, ywlsh校验\r\n" + 
				"	 * @throws Exception\r\n" + 
				"	 */\r\n" + 
				"	public Integer listCapitalFlowByBpmid(PbDfzjlsDto umDto) throws Exception {\r\n" + 
				"		Integer result = 0;\r\n" + 
				"		try {\r\n" + 
				"			StringBuffer sql = new StringBuffer();\r\n" + 
				"			sql.append(\"select gcid from pt_xmgc  where sxbm='\").append(PbDfzjlsConstants.SXBM).append(\"' and ( bpmid=\")\r\n" + 
				"					.append(umDto.getBpmid()).append(\" or ywlsh= '\").append(umDto.getYwlsh()).append(\"') \");\r\n" + 
				"			JSONObject map = new JSONObject();\r\n" + 
				"			map.put(\"page\", 1);\r\n" + 
				"			map.put(\"size\", 5);\r\n" + 
				"			map.put(\"sql\", sql.toString());\r\n" + 
				"			String resuts = PbHttpService.doPost(pbResourceConfig.getPtUrl() + ConstantPool.PlatformApi.Common.SQLQUERY,\r\n" + 
				"					map.toJSONString());\r\n" + 
				"			JSONObject re = JSONObject.parseObject(resuts);\r\n" + 
				"			result = re.getInteger(\"totalcount\");\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			log.error(\"bpmid, ywlsh校验失败：\" + e.getMessage(), e);\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return result;\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * 资金流水查询\r\n" + 
				"	 * @param queryDto\r\n" + 
				"	 * @return\r\n" + 
				"	 */\r\n" + 
				"	public DataResult listCapitalFlow(PbDfzjlsCxDto queryDto) throws Exception {\r\n" + 
				"		DataResult dr = new DataResult();\r\n" + 
				"		StringBuilder sql = new StringBuilder();\r\n" + 
				"		try {\r\n" + 
				"			sql.append(\r\n" + 
				"					\"select a.gcid \\\"gcid\\\",a.fssj \\\"fssj\\\",a.fsje \\\"fsje\\\",a.ywlsh \\\"ywlsh\\\",a.bpmid \\\"bpmid\\\",\"\r\n" + 
				"					+ \"a.dxbh \\\"dxbh\\\",a.xmbh \\\"xmbh\\\",b.id \\\"bzid\\\",b.beizhu.lrsj \\\"lrsj\\\", \"\r\n" + 
				"					+ \"b.beizhu.bdlx \\\"bdlx\\\",b.beizhu.sqrTxdz \\\"sqrTxdz\\\",b.beizhu.sqrbh \\\"sqrbh\\\",\"\r\n" + 
				"					+ \"b.beizhu.sqrBmmc \\\"sqrBmmc\\\",b.beizhu.sqrBmbh \\\"sqrBmbh\\\",b.beizhu.sqr \\\"sqr\\\", \"\r\n" + 
				"					+ \"b.beizhu.sqrZzmm \\\"sqrZzmm\\\",b.beizhu.syje \\\"syje\\\",b.beizhu.sqrDlwz \\\"sqrDlwz\\\",\"\r\n" + 
				"					+ \"b.beizhu.sqrBmid \\\"sqrBmid\\\",b.beizhu.bz \\\"bz\\\",b.beizhu.xmlb \\\"xmlb\\\",b.beizhu.xmmc \\\"xmmc\\\",\"\r\n" + 
				"					+ \"b.beizhu.dxbm \\\"dxbm\\\" \"\r\n" + 
				"					+ \"from pt_xmgc a inner join pt_xmgc_bc b on a.gcid=b.gcid \" + \"where  b.bzlb='01' \");\r\n" + 
				"			if (null != queryDto.getScbz()) {\r\n" + 
				"				sql.append(\"and a.scbz =\").append(queryDto.getScbz()).append(\" \");\r\n" + 
				"			}\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getSqr())) {\r\n" + 
				"				sql.append(\"and b.beizhu.sqr like '\").append(queryDto.getSqr()).append(\"%' \");\r\n" + 
				"			}\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getSqrbh())) {\r\n" + 
				"				sql.append(\"and b.beizhu.sqrbh = '\").append(queryDto.getSqrbh()).append(\"' \");\r\n" + 
				"			}\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getBdlx())) {\r\n" + 
				"				sql.append(\"and b.beizhu.bdlx = '\").append(queryDto.getBdlx()).append(\"' \");\r\n" + 
				"			}\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getKssj()) && StringUtils.isNotBlank(queryDto.getJssj())) {\r\n" + 
				"				sql.append(\"and substr(b.beizhu.lrsj, 0, 10) between '\").append(queryDto.getKssj()).append(\"' and '\")\r\n" + 
				"						.append(queryDto.getJssj()).append(\"'\");\r\n" + 
				"			}\r\n" + 
				"			if (null != queryDto.getBpmid() && 0 != queryDto.getBpmid()) {\r\n" + 
				"				sql.append(\"and a.bpmid = \").append(queryDto.getBpmid()).append(\" \");\r\n" + 
				"			}\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getYwlsh())) {\r\n" + 
				"				sql.append(\"and a.ywlsh = '\").append(queryDto.getYwlsh()).append(\"' \");\r\n" + 
				"			}\r\n" + 
				"			sql.append(\"and  a.sxbm='\").append(PbDfzjlsConstants.SXBM).append(\"' \");\r\n" + 
				"			if (StringUtils.isNotBlank(queryDto.getJgbh())) {\r\n" + 
				"				sql.append(\"and a.jgbh='\").append(queryDto.getJgbh()).append(\"' \");\r\n" + 
				"			}\r\n" + 
				"			sql.append(\" order by a.fssj desc,b.beizhu.lrsj desc\");\r\n" + 
				"			JSONObject map = new JSONObject();\r\n" + 
				"			map.put(\"page\", queryDto.getPage());\r\n" + 
				"			map.put(\"size\", queryDto.getSize());\r\n" + 
				"			map.put(\"sql\", sql.toString());\r\n" + 
				"			String resultstr = PbHttpService\r\n" + 
				"					.doPost(pbResourceConfig.getPtUrl() + ConstantPool.PlatformApi.Common.SQLQUERY, map.toJSONString());\r\n" + 
				"			dr = syJson.JsonToObject(resultstr, DataResult.class);\r\n" + 
				"\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return dr;\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * 删除资金流水\r\n" + 
				"	 * @param dto \r\n" + 
				"	 * @return\r\n" + 
				"	 * @throws Exception\r\n" + 
				"	 */\r\n" + 
				"	public DataResult deleteCapitalFlow(PbDfzjlsDto dto) throws Exception {\r\n" + 
				"		DataResult dr = new DataResult();\r\n" + 
				"		Project project = new Project();\r\n" + 
				"		ProjectProcessInfo processInfo = new ProjectProcessInfo();\r\n" + 
				"		SupplementaryInfo supInfo = new SupplementaryInfo();\r\n" + 
				"		try {\r\n" + 
				"			log.info(\"dto*****************************:\" + dto.toString());\r\n" + 
				"			supInfo.setBzid(null == dto.getBzid() ? 0 : dto.getBzid());\r\n" + 
				"			List<SupplementaryInfo> supplementaryInfos = new ArrayList<SupplementaryInfo>();\r\n" + 
				"			supplementaryInfos.add(supInfo);\r\n" + 
				"			processInfo.setGcid(null == dto.getGcid() ? 0 : dto.getGcid());\r\n" + 
				"			processInfo.setBpmid(null == dto.getBpmid() ? 0 : dto.getBpmid());\r\n" + 
				"			processInfo.setBcxx(supplementaryInfos);\r\n" + 
				"			List<ProjectProcessInfo> projectProcessInfos = new ArrayList<ProjectProcessInfo>();\r\n" + 
				"			projectProcessInfos.add(processInfo);\r\n" + 
				"			project.setProjectProcessInfo(projectProcessInfos);\r\n" + 
				"			log.info(\"project*****************************:\" + project.toString());\r\n" + 
				"			String resultstr = PbHttpService.doPost(\r\n" + 
				"					pbResourceConfig.getPtUrl() + ConstantPool.PlatformApi.Project.DELETE,\r\n" + 
				"					syJson.ObjectToJson(project));\r\n" + 
				"			dr = syJson.JsonToObject(resultstr, DataResult.class);\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return dr;\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"	/**\r\n" + 
				"	 * 获取新的bpmid（修改时用\r\n" + 
				"	 * @param @return\r\n" + 
				"	 * @param @throws Exception 参数\r\n" + 
				"	 * @return long 返回类型\r\n" + 
				"	 */\r\n" + 
				"	public long getBpmid() throws Exception {\r\n" + 
				"		JSONObject param;\r\n" + 
				"		long bpmid = 0;\r\n" + 
				"		try {\r\n" + 
				"			param = new JSONObject();\r\n" + 
				"			String result = PbHttpService\r\n" + 
				"					.doPost(pbResourceConfig.getPtUrl() + ConstantPool.PlatformApi.Common.BPMIDQUERY, param);\r\n" + 
				"			JSONObject object = JSONObject.parseObject(result);\r\n" + 
				"			JSONObject data = object.getJSONObject(\"data\");\r\n" + 
				"			bpmid = data.getLong(\"bpmid\");\r\n" + 
				"		} catch (Exception e) {\r\n" + 
				"			log.error(\"bpmid查询失败\" + e.getMessage(), e);\r\n" + 
				"			throw e;\r\n" + 
				"		}\r\n" + 
				"		return bpmid;\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"");


		StringBuilder sql2 = new StringBuilder();
		sql2.append(
				"select f.bpmid \"bpmid\",f.ywlsh \"ywlsh\",f.gcid \"gcid\",a.grbh  \"grbh\", a.xingming \"name\",a.zjhm \"zjhm\",a.xingbie \"xbbm\",h.mc \"xb\", a.sjhm \"sjhm\", "
						+ " e.beizhu ->> 'sxxm' \"sxxm\",e.beizhu ->> 'sqrZzmm' \"sqrZzmm\",e.beizhu ->> 'sqrbh' \"sqrbh\",e.beizhu ->> 'sqrBmid' \"sqrBmid\",e.beizhu ->> 'sqrTxdz' \"sqrTxdz\",e.beizhu ->> 'sqrBmmc' \"sqrBmmc\",e.beizhu ->> 'sqrDlwz' \"sqrDlwz\",e.beizhu ->> 'sqrBmbh' \"sqrBmbh\","
						+ " a.jiguan \"jg\", a.hjszd \"hjszd\",a.xzz \"xzz\", a.xueli \"xlbm\",a.xuewei \"xwbm\", a.jgbh \"jgbh\",  "
						+ " b.mc  \"xlmc\", c.mc \"xwmc\",d.beizhu ->> 'nianling' \"age\", d.id \"nlbzid\", e.id  \"dyxxbzid\",  "
						+ " e.beizhu ->> 'dylbbm' \"dylbbm\", e.beizhu ->> 'rdsj' \"rdsj\",e.beizhu ->> 'zzfg' \"zzfg\", e.beizhu ->> 'zzrq'  \"zzrq\",  "
						+ " e.beizhu ->> 'dylb' \"dylb\",e.beizhu ->> 'rzsj' \"rzsj\",e.beizhu ->> 'rdjsr' \"rdjsr\",e.beizhu ->> 'rddw' \"rddw\",e.beizhu ->> 'zzdw' \"zzdw\",g.beizhu ->> 'zzmm' \"zzmm\",g.beizhu ->> 'mz' \"mz\",i.id \"userid\"  from pt_xmgc f "
						+ "  inner join pt_xmgc_bc e on f.gcid=e.gcid and e.bzlb='01' "
						+ "  inner join pt_gr a on a.grbh=f.dxbh " + "  inner join pt_yh i on i.grbh=a.grbh "
						+ "  left join pt_bmb b on a.xueli = b.bm and b.bmlx = 'xueli' "
						+ "  left join pt_bmb c on a.xuewei = c.bm  and c.bmlx = 'xuewei' "
						+ " left join pt_bmb h on a.xingbie = h.bm and h.bmlx = 'xingbie'"
						+ "  left join pt_gr_bc d on d.grbh = a.grbh and d.bzlb = '00' "
						+ "  left join pt_gr_bc g on g.grbh=a.grbh and g.bzlb='01'");
		
		
		

		StringBuilder sql3 = new StringBuilder();
		sql3.append(" select b.beizhu ->> 'sqr' as \"sqr\",b.beizhu ->> 'sqrid' as \"sqrid\",b.beizhu ->> 'sex' " + 
				"as \"sex\", b.beizhu ->> 'sqsj' as \"sqsj\",b.beizhu ->> 'dzz' as \"dzz\",b.beizhu ->> " + 
				"'dzzid' as \"dzzid\",a.gcid as \"gcid\",b.id as \"bzid\",b.beizhu ->> 'thzt' as " + 
				"\"thzt\",b.beizhu ->> 'thztid' as \"thztid\",b.beizhu ->> 'thsj' as \"thsj\",b.beizhu ->> " + 
				"'thdd' as \"thdd\",b.beizhu ->> 'thnr' as \"thnr\",b.beizhu ->> 'prthbz' as " + 
				"\"prthbz\",b.beizhu ->> 'sqrTxdz' \"sqrTxdz\",b.beizhu ->> 'sqrbh' \"sqrbh\",b.beizhu ->> " + 
				"'sqrBmmc' \"sqrBmmc\",b.beizhu ->> 'sqrBmbh' \"sqrBmbh\",a.ywlsh \"ywlsh\",a.bpmid " + 
				"\"bpmid\",b.beizhu ->> 'sqrZzmm' \"sqrZzmm\",b.beizhu ->> 'sqrDlwz' \"sqrDlwz\",b.beizhu " + 
				"->> 'sqrBmid' \"sqrBmid\",b.beizhu ->> 'xmmc' \"xmmc\",a.xmbh \"xmbh\" from pt_xmgc a inner " + 
				"join pt_xmgc_bc b on a.gcid=b.gcid  where b.bzlb='01' and b.beizhu ->> 'lcjd' = '02' ");
		
		//替換備註
//		System.out.println(replaceSql(sql));
		//sql換行
		System.err.println(WordUtils.wrap(sql2.toString(),85));
//		System.out.println(sql3.toString());
		
	}
}
