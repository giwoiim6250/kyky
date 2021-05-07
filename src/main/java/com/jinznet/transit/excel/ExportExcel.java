/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
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

import com.google.common.collect.Lists;
import com.jinznet.transit.excel.annotation.ExportTitle;

/**
 * @author hejian
 * 
 */
public class ExportExcel<T> {

	public void exportExcel(Collection<T> dataset, OutputStream out) {
		String[] headers = null;
		Class<?> clazz = null;
		if(dataset != null && dataset.size() > 0){
			clazz = dataset.iterator().next().getClass();
			Field[] fields = clazz.getDeclaredFields();
			List<String> headerList = Lists.newArrayList();
			for (Field f : fields) {
				String title = "";
				ExportTitle annotation = f.getAnnotation(ExportTitle.class);
				if (annotation != null && annotation.value() != null && annotation.value().length() > 0) {
					title = annotation.value();
				} else {
					title = f.getName();
				}
				headerList.add(title);
			}
			headers = headerList.toArray(new String[0]);
		}
		exportExcel("Sheet", headers, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out) {
		exportExcel("Sheet", headers, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out, String pattern) {
		exportExcel("Sheet", headers, dataset, out, pattern);
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyyy-MM-dd"
	 */
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		// 白色背景 LIGHT_YELLOW背景
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
		// 把字体应用到当前的样式
		style2.setFont(font2);

		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);
		
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("leno");
		
		HSSFRow row = null;
		
		// 产生表格标题行
		if(headers != null){
			row = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
		}

		// 遍历集合数据，产生数据行
		if(dataset != null){
			
			Iterator<T> it = dataset.iterator();
			int index = 0;
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = (T) it.next();
				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				Field[] fields = t.getClass().getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(style2);
					Field field = fields[i];
					String fieldName = field.getName();
					String getMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					try {
						Class<? extends Object> tCls = t.getClass();
						Method getMethod = tCls.getMethod(getMethodName,
								new Class[] {});
						Object value = getMethod.invoke(t, new Object[] {});
						String textValue = null;
						if (value != null) {
							// 判断值的类型后进行强制类型转换
							if (value instanceof Boolean) {
								boolean bValue = (Boolean) value;
								textValue = "男";
								if (!bValue) {
									textValue = "女";
								}
							} else if (value instanceof Date) {
								Date date = (Date) value;
								SimpleDateFormat sdf = new SimpleDateFormat(pattern);
								textValue = sdf.format(date);
							} else if (value instanceof byte[]) {
								// 有图片时，设置行高为60px;
								row.setHeightInPoints(60);
								// 设置图片所在列宽度为80px,注意这里单位的一个换算
								sheet.setColumnWidth(i, (short) (35.7 * 80));
								// sheet.autoSizeColumn(i);
								byte[] bsValue = (byte[]) value;
								HSSFClientAnchor anchor = new HSSFClientAnchor(0,
										0, 1023, 255, (short) 6, index, (short) 6,
										index);
								anchor.setAnchorType(2);
								patriarch.createPicture(anchor, workbook
										.addPicture(bsValue,
												HSSFWorkbook.PICTURE_TYPE_JPEG));
							} else {
								// 其它数据类型都当作字符串简单处理
								textValue = value.toString();
							}
						}
						
						// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
						if (textValue != null) {
							Pattern p = Pattern.compile("^//d+(//.//d+)?$");
							Matcher matcher = p.matcher(textValue);
							if (matcher.matches()) {
								// 是数字当作double处理
								cell.setCellValue(Double.parseDouble(textValue));
							} else {
								HSSFRichTextString richString = new HSSFRichTextString(
										textValue);
								richString.applyFont(font3);
								cell.setCellValue(richString);
							}
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} finally {
						// 清理资源
					}
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		/*// 测试学生
		ExportExcel<Student> ex = new ExportExcel<Student>();
		String[] headers = null;
		Field[] fields = Student.class.getDeclaredFields();
		List<String> headerList = Lists.newArrayList();
		for (Field f : fields) {
			String title = "";
			ExportTitle annotation = f.getAnnotation(ExportTitle.class);
			if (annotation != null && annotation.value() != null
					&& annotation.value().length() > 0) {
				title = annotation.value();
			} else {
				title = f.getName();
			}
			headerList.add(title);
		}
		headers = headerList.toArray(new String[0]);
		List<Student> dataset = new ArrayList<Student>();
		dataset.add(new Student(10000001, "张三", 20, true, new Date()));
		dataset.add(new Student(20000002, "李四", 24, false, new Date()));
		dataset.add(new Student(30000003, "王五", 22, true, new Date()));
		OutputStream out = new FileOutputStream("E://a.xls");
		ex.exportExcel(headers, dataset, out);*/
		Field[] fields = Student.class.getDeclaredFields();
		for (Field f : fields) {
			String title = "";
			ExportTitle annotation = f.getAnnotation(ExportTitle.class);
			if (annotation != null && annotation.value() != null
					&& annotation.value().length() > 0) {
				title = annotation.value();
			} else {
				title = f.getName();
			}
			System.out.println(title);
		}
	}

}

class Student {
	@ExportTitle("编号")
	private long id;

	@ExportTitle("姓名")
	private String name;

	@ExportTitle("年龄")
	private int age;

	@ExportTitle("性别")
	private boolean sex;

	@ExportTitle("生日")
	private Date birthday;

	public Student() {
	}

	public Student(long id, String name, int age, boolean sex, Date birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
