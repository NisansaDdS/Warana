package com.cse.warana.utility.AggregatedProfileGenerator.jate.model;

import uk.ac.shef.wit.commons.UtilFiles;

import java.io.IOException;
import java.net.URL;

/**
 * @author <a href="mailto:z.zhang@dcs.shef.ac.uk">Ziqi Zhang</a>
 */


public class DocumentImpl implements Document {

	public URL _url;

   public DocumentImpl(URL url) {
	   _url = url;
   }

   public URL getUrl() {
      return _url;
   }

   public String getContent() {
      String content = null;
      try {
         content = uk.ac.shef.wit.commons.UtilFiles.getContent(_url).toString();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return content;
   }

   public String toString() {
      return _url.toString();
   }

   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final DocumentImpl that = (DocumentImpl) o;

	   return that.getUrl().equals(getUrl());

   }

   public int hashCode() {
      return _url.hashCode();
   }
}
