/**
 * @FileName: repalaceFormat.java
 * @creator zhaohanyang
 * @date Mar 9, 2021
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.replace;

import java.text.MessageFormat;

/**
 * @ClassName: repalaceFormat
 * @Description: 
 * @author zhaohanyang
 * @date Mar 9, 2021
 * @version V1.0
 */
public class repalaceFormat {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder txt = new StringBuilder();
		txt.append("<html>\r\n").append("	<head>\r\n")
				.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n")
				.append("		<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\r\n")
				.append("		<meta name=\"generator\" content=\"Aspose.Words for .NET 15.1.0.0\" />\r\n")
				.append("		<title>\r\n").append("		</title>\r\n").append("	</head>\r\n").append("	<body>\r\n")
				.append("		<div>\r\n")
				.append("			<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("				<span style=\"font-family:宋体; font-size:20pt\">\r\n")
				.append("					{0}\r\n").append("				</span>\r\n")
				.append("				<br />\r\n").append("			</p>\r\n")
				.append("			<p style=\"margin:0pt; orphans:0; text-align:right; widows:0\">\r\n")
				.append("				<span style=\"font-family:宋体; font-size:10pt\">\r\n")
				.append("					会议时间：\r\n").append("				</span>\r\n")
				.append("				<span style=\"font-family:Calibri; font-size:10pt\">\r\n")
				.append("					{1}\r\n").append("				</span>\r\n").append("			</p>\r\n")
				.append("			<table cellspacing=\"0\" cellpadding=\"0\" style=\"border-collapse:collapse; margin-left:0pt\">\r\n")
				.append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								会议名称\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">	{2}\r\n")
				.append("							</span>\r\n").append("						</p>\r\n")
				.append("					</td>\r\n").append("				</tr>\r\n")
				.append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								会议地点\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{3}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								会议主持人\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{4}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								会议记录人\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{5}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								应到人数\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:Calibri; font-size:10.5pt\">\r\n")
				.append("								{6}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								实到人数\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:Calibri; font-size:10.5pt\">\r\n")
				.append("								{7}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								缺席人员和缺席原因\r\n")
				.append("							</span>\r\n").append("						</p>\r\n")
				.append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{8}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								出席人员\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{9}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								列席人员\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								{10}\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("				</tr>\r\n").append("				<tr style=\"height:45pt\">\r\n")
				.append("					<td style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">\r\n")
				.append("								学习内容\r\n").append("							</span>\r\n")
				.append("						</p>\r\n").append("					</td>\r\n")
				.append("					<td colspan=\"3\" style=\"border-bottom-color:#000000; border-bottom-style:solid; border-bottom-width:0.75pt; border-left-color:#000000; border-left-style:solid; border-left-width:0.75pt; border-right-color:#000000; border-right-style:solid; border-right-width:0.75pt; border-top-color:#000000; border-top-style:solid; border-top-width:0.75pt; padding-left:0.12pt; padding-right:0.12pt; vertical-align:middle; width:199pt\">\r\n")
				.append("						<p style=\"margin:0pt; orphans:0; text-align:center; widows:0\">\r\n")
				.append("							<span style=\"font-family:宋体; font-size:10.5pt\">	{11}\r\n")
				.append("							</span>\r\n").append("						</p>\r\n")
				.append("					</td>\r\n").append("				</tr>\r\n")
				.append("			</table>\r\n")
				.append("			<p style=\"margin:0pt; orphans:0; text-align:justify; widows:0\">\r\n")
				.append("				<span style=\"font-family:Calibri; font-size:10.5pt\">\r\n")
				.append("					&#xa0;\r\n").append("				</span>\r\n")
				.append("			</p>\r\n").append("		</div>\r\n")
				.append("		<div class=\"cnzz\" style=\"display: none;\">\r\n")
				.append("			<script src=\"https://s23.cnzz.com/z_stat.php?id=1277655852&web_id=1277655852\"\r\n")
				.append("			language=\"JavaScript\">\r\n").append("			</script>\r\n")
				.append("		</div>\r\n").append("	</body>\r\n").append("\r\n").append("</html>");
		String message = MessageFormat.format(txt.toString(), "党333课22", "2020-22-22", "会2议名22称", "石家庄", "zhoutao",
				"董卿", "50", "42", "yuanyin", "张三，李四", "elle,fanning",
				"会议内容无论是符合无论是符合" + "无论是符合无论是符合无论是符合无论是符合无论是符合无论是符合无论是符合");
		System.out.println(txt);
	}

}
