<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2006-09-16T00:00:00Z</Created>
  <LastSaved>2020-12-23T08:32:05Z</LastSaved>
  <Version>15.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>8010</WindowHeight>
  <WindowWidth>14810</WindowWidth>
  <WindowTopX>240</WindowTopX>
  <WindowTopY>110</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s16">
   <NumberFormat ss:Format="@"/>
  </Style>
  <Style ss:ID="s18">
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#FF0000"/>
  </Style>
  <Style ss:ID="s19">
   <Interior ss:Color="#FFFF00" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s20">
   <Alignment ss:Horizontal="Center" ss:Vertical="Bottom"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <#- - 注意ExpandedRowCount值小于导出表格行数会报错 - ->
  <Table ss:ExpandedColumnCount="11" ss:ExpandedRowCount="99" x:FullColumns="1"
   x:FullRows="1" ss:DefaultRowHeight="14">
   <Column ss:Index="2" ss:StyleID="s16" ss:AutoFitWidth="0"/>
   <Column ss:Index="4" ss:StyleID="s18" ss:AutoFitWidth="0"/>
   <Column ss:AutoFitWidth="0" ss:Width="109.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="118.5"/>
   <Row>
    <Cell><Data ss:Type="String">姓名</Data></Cell>
    <Cell><Data ss:Type="String">身份证号</Data></Cell>
    <Cell><Data ss:Type="String">所在支部</Data></Cell>
    <Cell><Data ss:Type="String">基本工资</Data></Cell>
    <Cell><Data ss:Type="String">基础性绩效工资</Data></Cell>
    <Cell ss:StyleID="s19"><Data ss:Type="String">养老保险个人缴费额</Data></Cell>
    <Cell><Data ss:Type="String">医疗保险个人缴费额</Data></Cell>
    <Cell><Data ss:Type="String">失业保险个人缴费额</Data></Cell>
    <Cell><Data ss:Type="String">住房公积金保险个人缴费额</Data></Cell>
    <Cell><Data ss:Type="String">平均每月扣税</Data></Cell>
    <Cell><Data ss:Type="String">备注</Data></Cell>
   </Row>
   <#list dfxxs as dfxx>
   <Row>
    <Cell><Data ss:Type="String">${dfxx.xm}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.sfzh}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.szzb}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.jbgz}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.jcxj}</Data></Cell>
    <Cell ss:StyleID="s19"><Data ss:Type="String">${dfxx.ylbx}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.ylbx}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.sybx}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.zfgj}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.pjmy}</Data></Cell>
    <Cell><Data ss:Type="String">${dfxx.bz}</Data></Cell>
   </Row>
   </#list>
   <Row>
    <Cell ss:MergeAcross="10" ss:StyleID="s20"><Data ss:Type="String">${ludingji}</Data></Cell>
   </Row>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>300</HorizontalResolution>
    <VerticalResolution>300</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>6</ActiveRow>
     <ActiveCol>3</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
