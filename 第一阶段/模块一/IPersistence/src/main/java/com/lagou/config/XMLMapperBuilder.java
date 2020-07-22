package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void putConfiguration(List<Element> list,String namespace){
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            if(resultType==null){
                resultType="java.lang.String";
            }
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);
            String key = namespace + "." + id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }
    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");

        List<Element> elements = rootElement.elements();
        for (Element ment : elements) {
            String dd = ment.getName();
            if (dd.equals("select")) {
                List<Element> list = rootElement.selectNodes("//select");
                putConfiguration(list,namespace);
            }else if(dd.equals("insert")){
                List<Element> list = rootElement.selectNodes("//insert");
                putConfiguration(list,namespace);
            } else  if(dd.equals("update")){
                List<Element> list = rootElement.selectNodes("//update");
                putConfiguration(list,namespace);
            }else if(dd.equals("delete")){
                List<Element> list = rootElement.selectNodes("//delete");
                putConfiguration(list,namespace);
            }
                }


            }
        }
