package com.firebirdcss.util.json.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.firebirdcss.util.json.JsonUtilities;

public class TestJsonToHtml {
	/* JSON Samples */
	private static final String JSON_SAMPLE1 = 
			"{ \n" + 
			"  \"first_name\" : \"Sammy\",\n" + 
			"  \"last_name\" : \"Shark\",\n" + 
			"  \"location\" : \"Ocean\",\n" + 
			"  \"websites\" : [ \n" + 
			"    {\n" + 
			"      \"description\" : \"work\",\n" + 
			"      \"URL\" : \"https://www.digitalocean.com/\"\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"desciption\" : \"tutorials\",\n" + 
			"      \"URL\" : \"https://www.digitalocean.com/community/tutorials\"\n" + 
			"    }\n" + 
			"  ],\n" + 
			"  \"social_media\" : [\n" + 
			"    {\n" + 
			"      \"description\" : \"twitter\",\n" + 
			"      \"link\" : \"https://twitter.com/digitalocean\"\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"description\" : \"facebook\",\n" + 
			"      \"link\" : \"https://www.facebook.com/DigitalOceanCloudHosting\"\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"description\" : \"github\",\n" + 
			"      \"link\" : \"https://github.com/digitalocean\"\n" + 
			"    }\n" + 
			"  ]\n" + 
			"}";
	
	/* STYLE Samples */
	private static final String STYLE_SAMPLE1 = 
			  "table, th, td {"
			+    "border: 1px solid black;"
			+ "}";
	
	/* EXPECTED Results */
	private static final String EXPECTED1 = "<!DOCTYPE html><html><head><title>JSON to HTML</title><style>table, th, td {border: 1px solid black;}tr:hover {background-color: #f5f5f5;}td {padding: 5px;}table {width: 100%;}.headings {font-weight:bold;}</style></head><body><table><tr><td class=\"headings\">first_name</td><td>Sammy</td></tr><tr><td class=\"headings\">last_name</td><td>Shark</td></tr><tr><td class=\"headings\">location</td><td>Ocean</td></tr><tr><td class=\"headings\">websites</td><td><table><tr><td class=\"headings\">description</td><td>work</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/</td></tr></table><table><tr><td class=\"headings\">desciption</td><td>tutorials</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/community/tutorials</td></tr></table></td></tr><tr><td class=\"headings\">social_media</td><td><table><tr><td class=\"headings\">description</td><td>twitter</td></tr><tr><td class=\"headings\">link</td><td>https://twitter.com/digitalocean</td></tr></table><table><tr><td class=\"headings\">description</td><td>facebook</td></tr><tr><td class=\"headings\">link</td><td>https://www.facebook.com/DigitalOceanCloudHosting</td></tr></table><table><tr><td class=\"headings\">description</td><td>github</td></tr><tr><td class=\"headings\">link</td><td>https://github.com/digitalocean</td></tr></table></td></tr></table></body></html>";
	private static final String EXPECTED2 = "<!DOCTYPE html><html><head><title>Title</title><style></style></head><body><table><tr><td class=\"headings\">first_name</td><td>Sammy</td></tr><tr><td class=\"headings\">last_name</td><td>Shark</td></tr><tr><td class=\"headings\">location</td><td>Ocean</td></tr><tr><td class=\"headings\">websites</td><td><table><tr><td class=\"headings\">description</td><td>work</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/</td></tr></table><table><tr><td class=\"headings\">desciption</td><td>tutorials</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/community/tutorials</td></tr></table></td></tr><tr><td class=\"headings\">social_media</td><td><table><tr><td class=\"headings\">description</td><td>twitter</td></tr><tr><td class=\"headings\">link</td><td>https://twitter.com/digitalocean</td></tr></table><table><tr><td class=\"headings\">description</td><td>facebook</td></tr><tr><td class=\"headings\">link</td><td>https://www.facebook.com/DigitalOceanCloudHosting</td></tr></table><table><tr><td class=\"headings\">description</td><td>github</td></tr><tr><td class=\"headings\">link</td><td>https://github.com/digitalocean</td></tr></table></td></tr></table></body></html>";
	private static final String EXPECTED3 = "<!DOCTYPE html><html><head><title></title><style>table, th, td {border: 1px solid black;}</style></head><body><table><tr><td class=\"headings\">first_name</td><td>Sammy</td></tr><tr><td class=\"headings\">last_name</td><td>Shark</td></tr><tr><td class=\"headings\">location</td><td>Ocean</td></tr><tr><td class=\"headings\">websites</td><td><table><tr><td class=\"headings\">description</td><td>work</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/</td></tr></table><table><tr><td class=\"headings\">desciption</td><td>tutorials</td></tr><tr><td class=\"headings\">URL</td><td>https://www.digitalocean.com/community/tutorials</td></tr></table></td></tr><tr><td class=\"headings\">social_media</td><td><table><tr><td class=\"headings\">description</td><td>twitter</td></tr><tr><td class=\"headings\">link</td><td>https://twitter.com/digitalocean</td></tr></table><table><tr><td class=\"headings\">description</td><td>facebook</td></tr><tr><td class=\"headings\">link</td><td>https://www.facebook.com/DigitalOceanCloudHosting</td></tr></table><table><tr><td class=\"headings\">description</td><td>github</td></tr><tr><td class=\"headings\">link</td><td>https://github.com/digitalocean</td></tr></table></td></tr></table></body></html>";
	
	/**
	 * Test the basic functionality of the utilities method's ability to 
	 * translate JSON to HTML.
	 * 
	 */
	@Test
	public void testBasicConversion() {
		assertEquals(EXPECTED1, JsonUtilities.jsonToHtml(JSON_SAMPLE1));
	}
	
	/**
	 * Test the ability to inject a HTML Document title into the generated HTML code.
	 * 
	 */
	@Test
	public void testInjectTitle() {
		assertEquals(EXPECTED2, JsonUtilities.jsonToHtml("Title", "", JSON_SAMPLE1));
	}
	
	/**
	 * Test the ability to inject CSS Style code into the generated HTML Code.
	 * 
	 */
	@Test
	public void testInjectStyle() {
		assertEquals(EXPECTED3, JsonUtilities.jsonToHtml("", STYLE_SAMPLE1, JSON_SAMPLE1));
	}
}
