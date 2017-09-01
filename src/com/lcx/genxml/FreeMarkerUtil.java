package com.lcx.genxml;

import java.io.StringWriter;
import java.net.URL;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;



public class FreeMarkerUtil {
    public static Configuration cfg;
    static {
        try{
            cfg = new Configuration();

            /*TemplateLoader ctl = new TemplateLoader(){
                public  Object findTemplateSource(String s)
                        throws IOException{
                    return ResourceStreamUtil.getResourceStream(s);
                }

                public  long getLastModified(Object obj){
                     return 0;
                }

                public  Reader getReader(Object obj, String s)
                        throws IOException{
                     return new InputStreamReader((InputStream)obj,s);
                }

                public  void closeTemplateSource(Object obj)
                        throws IOException{
                    
                }
            };
            cfg.setTemplateLoader(ctl);*/
            //cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "");
            
         
            //TemplateLoader tempLoder1= new ClassTemplateLoader(FreeMarkerUtil.class, "");
            TemplateLoader tempLoder2=  URLTemplateLoader.class.newInstance();
        
            cfg.setTemplateLoader(tempLoder2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    public static String transformString(String templateFile, 
            Map map) throws Exception {
        StringWriter w = new StringWriter();
        Template template = cfg.getTemplate("template.vm");
        
     /*   BeansWrapper beansWrapper = new BeansWrapper();
        beansWrapper.setNullModel(TemplateModel.NOTHING);*/
        template.process(map, w);
        w.flush();
        w.close();
        return w.toString();
        
    }

}
