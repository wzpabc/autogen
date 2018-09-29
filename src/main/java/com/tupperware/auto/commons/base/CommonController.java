package com.tupperware.auto.commons.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.tupperware.auto.commons.utils.ExportExcel;
import com.tupperware.auto.commons.utils.VeDate;
 

public abstract class CommonController<T>   {
    private static Logger logger = Logger.getLogger(CommonController.class);
	@Autowired
	public HttpServletResponse response;
	@Autowired
	public HttpServletRequest request;

	private static final String PDF_ROOT = "/WEB-INF/downloads/pdf/";
	private static final String EXCEL_ROOT = "/WEB-INF/downloads/excel/";
	private static final String DOC_ROOT = "/WEB-INF/downloads/doc/";
	private static final String FILE_ROOT = "/WEB-INF/downloads/file/";

	private static final String CT_EXCEL="application/x-xls";
	private static final String CT_PDF="application/pdf";
	private static final String CT_DOC="application/msword"; 
	private static final String CT_FILE="application/msword"; 
	
	private static final int SHEET_MAX_ROW=65535;
	
	
	public void downloadPDFResource(String fileName) {
		download(Paths.get(request.getServletContext().getRealPath(PDF_ROOT), fileName),CT_PDF);
	}

	public void downloadExcelResource(String fileName) { 
		download(Paths.get(request.getServletContext().getRealPath(EXCEL_ROOT), fileName),CT_EXCEL);
	}

	public void downloadDoclResource(String fileName) {
		download(Paths.get(request.getServletContext().getRealPath(DOC_ROOT), fileName),CT_DOC);
	}

	public void downloadFileResource(String fileName) {
		download(Paths.get(request.getServletContext().getRealPath(FILE_ROOT), fileName),CT_FILE);
		 
	}
    /**
     * 通用下载
     * @param file
     * @param contenttype
     */
	public void download(Path file,String contenttype) {
		
		if (Files.exists(file)) {
			//response.setContentType("application/pdf");
			response.setContentType(contenttype==null?CT_FILE:contenttype);			
			response.addHeader("Content-Disposition", "attachment; filename=" + file.getFileName());
			try {
				logger.info("Downloading file "+file.toString());
				OutputStream out = response.getOutputStream();
				Files.copy(file, out);
				out.flush();
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				logger.error(ex.getMessage());
			}
		}
	}

	/**
	 * 通用下载
	 * 
	 * @param response
	 * @param request
	 * @param dataset
	 * @param t
	 */
	public void downloadExcel(List<T> dataset, Class<T> t) {
		String filename = t.getSimpleName();
		String sheetName="";
		int index=1;
		if (!dataset.isEmpty()) {
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + filename+"_"+VeDate.getStringTodayAsEndFix() + ".xls");
			// 测试图书
			ExportExcel<T> ex = new ExportExcel<T>();
			String[] headers = ex.getHeaders(t);
			try {
				OutputStream out = response.getOutputStream();				
				if(dataset.size()<=SHEET_MAX_ROW){
					ex.exportExcel(headers, dataset, out);
				}else{					
					HSSFWorkbook workbook = new HSSFWorkbook();		 
					for(List<T> sublist:getSubList(dataset,SHEET_MAX_ROW)) {
						sheetName=t.getSimpleName()+"_"+String.valueOf(index); 
						logger.info("=============== index="+String.valueOf(index)+"===============");
						ex.exportExcelMutil(sheetName, headers, sublist, out, workbook);
						index++;
					}
					workbook.write(out);
				}
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param pagesize
	 * @return
	 */
	public List<List<T>> getSubList(List<T> list, int pagesize) {
		List<List<T>> result = new ArrayList<List<T>>();
		int totalcount = list.size();
		int pagecount = 0;
		int m = totalcount % pagesize;
		if (m > 0) {
			pagecount = totalcount / pagesize + 1;
		} else {
			pagecount = totalcount / pagesize;
		}

		for (int i = 1; i <= pagecount; i++) {
			if (m == 0) {
				List<T> subList = list.subList((i - 1) * pagesize, pagesize * (i));
				result.add(subList);
			} else {
				if (i == pagecount) {
					List<T> subList = list.subList((i - 1) * pagesize, totalcount);
					result.add(subList);
				} else {
					List<T> subList = list.subList((i - 1) * pagesize, pagesize * (i));
					result.add(subList);
				}
			}
		}
		return result;

	}
	 
}
