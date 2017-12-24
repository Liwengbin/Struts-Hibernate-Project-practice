/**
 * 
 */
package com.collect.service;

import java.io.File;

import com.collect.domain.UrlContent;

/**
 * @author ÀîÎÄ±ø
 *
 */
public interface CaptureUrlService {
	public UrlContent GetUrlContent(String url);
	public void importMenu(File file,String email);
}
