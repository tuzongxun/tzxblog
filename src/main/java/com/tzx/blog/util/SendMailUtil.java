package com.tzx.blog.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 邮件发送工具类
 * 
 * @author tzx
 * @date 2018年1月29日
 */
@Component
public class SendMailUtil {
	public static void main(String[] args) {
		SendMailUtil send = new SendMailUtil();
		send.sendEmail("test");
	}

	@Value("${sendEmailAdd}")
	private String sendEmailAdd;
	@Value("${emailName}")
	private String emailName;
	@Value("${emailPwd}")
	private String emailPwd;
	@Value("${reciveEmailAdd}")
	private String reciveEmailAdd;

	public boolean sendEmail(String comment) {
		// 从配置文件中读取配置信息
		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.163.com");
		pro.put("mail.smtp.auth", "true");
		// Properties pro = mailConfig.getProperties();
		// 根据邮件的回话属性构造一个发送邮件的Session
		MailAuthenticator authenticator = new MailAuthenticator(emailName, emailPwd);
		Session session = Session.getInstance(pro, authenticator);
		// 监控邮件命令
		try {
			// 根据Session 构建邮件信息
			Message message = new MimeMessage(session);
			// 创建邮件发送者地址
			Address from = new InternetAddress(sendEmailAdd);
			// 设置邮件消息的发送者
			message.setFrom(from);
			// 验证邮箱地址
			List<String> auth = new ArrayList<String>();
			auth.add(reciveEmailAdd);
			String toAddress = validateEmail(auth);
			if (!toAddress.isEmpty()) {
				// 创建邮件的接收者地址
				Address[] to = InternetAddress.parse(toAddress);
				// 设置邮件接收人地址
				message.setRecipients(Message.RecipientType.TO, to);
				message.setSubject("新评论");
				// 邮件容器
				MimeMultipart mimeMultiPart = new MimeMultipart();
				// 设置HTML
				BodyPart bodyPart = new MimeBodyPart();
				// String htmlText = "123456";
				bodyPart.setContent(comment, "text/html;charset=utf-8");
				mimeMultiPart.addBodyPart(bodyPart);
				// 添加附件
				// List<String> fileList = new ArrayList<String>();
				// fileList.add("C:\\Users\\tuzongxun123\\Desktop\\自主服务API.docx");

				// if (fileList != null) {
				// BodyPart attchPart = null;
				// for (int i = 0; i < fileList.size(); i++) {
				// if (!fileList.get(i).isEmpty()) {
				// attchPart = new MimeBodyPart();
				// // 附件数据源
				// DataSource source = new FileDataSource(fileList.get(i));
				// // 将附件数据源添加到邮件体
				// attchPart.setDataHandler(new DataHandler(source));
				// // 设置附件名称为原文件名
				// attchPart.setFileName(MimeUtility.encodeText(source.getName()));
				// mimeMultiPart.addBodyPart(attchPart);
				// }
				// }
				// }
				message.setContent(mimeMultiPart);
				message.setSentDate(new Date());
				// 保存邮件
				message.saveChanges();
				// 发送邮件
				Transport.send(message);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("邮件发送失败");
		}
		return false;
	}

	/**
	 * @title validateEmail
	 * @Description 验证邮箱格式
	 * @param emailList
	 * @return string
	 */
	public String validateEmail(List<String> emailList) {
		StringBuffer buffer = new StringBuffer();
		if (!emailList.isEmpty()) {
			String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern p = Pattern.compile(regEx);
			for (int i = 0; i < emailList.size(); i++) {
				Matcher match = p.matcher(emailList.get(i));
				if (match.matches()) {
					buffer.append(emailList.get(i));
					if (i < emailList.size() - 1) {
						buffer.append(",");
					}
				}
			}
		}
		return buffer.toString();
	}
}
