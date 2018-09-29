package com.tupperware.auto.commons.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
 
 

public class ExportExcel<T> {
	
	public String[] getHeaders(Class<T> t) {
		List<String> list = new ArrayList<String>();

		for (Field f : t.getDeclaredFields()) {
			if(!f.getName().equals("serialVersionUID")){
				list.add(f.getName()); 
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		return arr;
	}
	
	public void exportExcel(Collection<T> dataset, OutputStream out) throws IOException {
		exportExcel("testPOI", null, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(String[] headers, Collection<T> dataset, OutputStream out) throws IOException {
		exportExcel("testPOI", headers, dataset, out, "yyyy-MM-dd");
	}
	
	public void exportExcelMutil(String title,String[] headers, Collection<T> dataset, OutputStream out,HSSFWorkbook workbook) {
		exportExcelMutil(title, headers, dataset, out, "yyyy-MM-dd",workbook);
	}

	public void exportExcel(String[] headers, Collection<T> dataset, OutputStream out, String pattern) throws IOException {
		exportExcel("testPOI", headers, dataset, out, pattern);

	}
	public void exportExcelMutil(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern,HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet(title);
		sheet.setDefaultColumnWidth((short) 15);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		style.setFont(font);

		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.WHITE.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

		style2.setFont(font2);

		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		comment.setAuthor("leno");

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
			//System.out.println(headers[i]);
		}
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext() && index<=65534) {//excel 2003最多导65535行
			
			index++;
			row = sheet.createRow(index);
			
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] allfields = t.getClass().getDeclaredFields();
			List<Field> fl = new ArrayList<Field>();
			for (Field f : allfields) {
				if (!f.getName().equals("serialVersionUID")) {
					fl.add(f);
				}
			}
			Field[] fields=new Field[fl.size()];
			fl.toArray(fields);
			
			for (short i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fileName = field.getName();
				String getMethodName = "get" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						textValue = "男";
						if (!bValue)
							textValue = "女";

					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);

					}else if (value instanceof Double) {
					    NumberFormat nf = NumberFormat.getInstance();
				        nf.setGroupingUsed(false);
				        textValue = nf.format(value);	
					} else if (value instanceof Byte[]) {
						textValue = (value == null?"":value.toString()); 
					} else {						
						textValue = (value == null?"":value.toString()); 
						//System.out.println(fileName+"="+(value == null?"xxxxxxx":value.toString()));
					}
					//System.out.println(textValue);
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richTextString = new HSSFRichTextString(textValue);
//							HSSFFont font3 = workbook.createFont();
//							font3.setColor(HSSFColor.BLACK.index);
//							richTextString.applyFont(font3);
							cell.setCellValue(richTextString); 
						}
					}

				} catch (SecurityException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		
	}
	public void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		exportExcelMutil(title,headers,dataset,out,pattern,workbook);
		workbook.write(out);
	}

}