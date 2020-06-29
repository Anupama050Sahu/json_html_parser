package com.htmlparser;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HtmlToJsonParser {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String fileName = "New Lead .html";
		Scanner sc =new Scanner(System.in);
		System.out.println("Please provide the html file path..\n");
		String path=sc.nextLine();
		System.out.println(path);
		Document doc = Jsoup.parse(new File(path), "utf-8");
		System.out.println("Read html file from location: "+fileName);
		//TO EXTRACT THE NAME FROM THE GIVEN HTML FILE
		Map<String, String> addressMap = new HashMap<String, String>();
		String name = null;
		Elements body = doc.select("table.width320");
		for (Element e : body.select("tr tr tr")) {
			name = e.select("td.aligncenter font.font16").text();
			if (!name.equals("")) {

				String[] nameString = name.split(" ");
				String formattedName = (nameString[1] + nameString[2]);
				addressMap.put("name", formattedName);
			}

		}
		//To get all the hyperlinks present in the html file
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			String linkValue = link.attr("href");
			// condition to get a specific mobile number
			String text = link.text();
			if (text.equals("111-222-3333")) {
				addressMap.put("mobile", text);
// condition to get a specific  email address
			} else if (text.equals("testlead@gmail.com")) {
				addressMap.put("email", text);
//condition to get a specific address
			} else if (text.equals("43824 W Sagebrush Trl, Maricopa, AZ 85138")) {
				addressMap.put("address", text);
			}

		}
		//way to converting the  code to {output.json}
		
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String json = objectMapper.writeValueAsString(addressMap);
			System.out.println("Output json is\n"+json);
			FileOutputStream fos = new FileOutputStream("output.json");
			DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			outStream.writeUTF(json);
			outStream.close();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
