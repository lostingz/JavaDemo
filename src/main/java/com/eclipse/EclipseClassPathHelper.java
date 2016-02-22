package com.eclipse;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
public class EclipseClassPathHelper {
    private Map<String, Element> result = new TreeMap<String, Element>();
    @SuppressWarnings("unchecked")
    public void merge(File projectHome) throws Exception {
        FileFinder finder = new FileFinder(".classpath", 2);
        List<File> files = finder.find(projectHome);
        SAXBuilder sax = new SAXBuilder(false);
        for (File file : files) {
            Document doc = sax.build(file);
            Element root = doc.getRootElement();
            List<Element> beans = root.getChildren();
            for (Element element : beans) {
                String kind = element.getAttribute("kind").getValue();
                String path = element.getAttribute("path").getValue();
                String key = kind + path;
                if (!result.containsKey(key)) {
                    result.put(key, element);
                }
            }
        }
        XMLOutputter putter = new XMLOutputter();
        for (Entry<String, Element> entry : result.entrySet()) {
            System.out.println(putter.outputString(entry.getValue()));
        }
    }
    public static class FileFinder {
        private String fn;
        private List<File> result = new ArrayList<File>();
        private int level;
        private int depth;
        public FileFinder(String searchFileName, int recursiveDeepth) {
            this.fn = searchFileName;
            this.level = recursiveDeepth;
        }
        public List<File> find(File file) throws Exception {
            if (file.isFile()) {
                if (equalsIgnoreCase(file.getName(), fn)) {
                    result.add(file);
                }
            } else {
                depth++;
                if (depth <= level && !isExclude(file.getName())) {
                    File[] files = file.listFiles();
                    for (File f : files) {
                        find(f);
                    }
                }
                depth--;
            }
            return result;
        }
        private boolean isExclude(String fn) {
            return equalsIgnoreCase(fn, ".svn") || equalsIgnoreCase(fn, ".settings") || equalsIgnoreCase(fn, "bin")
                    || equalsIgnoreCase(fn, "target");
        }
    }
    public static void main(String[] args) {
        EclipseClassPathHelper helper = new EclipseClassPathHelper();
        try {
            helper.merge(new File("E:\\workSpaceZheng\\gatzs\\"));
        } catch (Exception e) {
            e.printStackTrace();
        } //高考项目的主目录
    }
}