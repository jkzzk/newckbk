package com.baidu.ueditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.ueditor.define.ActionMap;

/**
 * ���ù�����
 * @author hancong03@baidu.com
 *
 */
public final class ConfigManager {
    private static final String configFileName = "config.json";

    // Ϳѻ�ϴ�filename����
    private final static String SCRAWL_FILE_NAME = "scrawl";

    // Զ��ͼƬץȡfilename����
    private final static String REMOTE_FILE_NAME = "remote";
    private String              parentPath       = null;
    private JSONObject          jsonConfig       = null;
    private final String        rootPath;
    private final String        originalPath;
    private final String        contextPath;

    /*
     * ͨ��һ��������·������һ�����ù������� �ù�����Ҫ���ַ·������Ŀ¼�±������config.properties�ļ�
     */
    private ConfigManager(String rootPath, String contextPath, String uri) throws FileNotFoundException, IOException {
        rootPath         = rootPath.replace("\\", "/");
        this.rootPath    = rootPath;
        this.contextPath = contextPath;

        if (contextPath.length() > 0) {
            this.originalPath = this.rootPath + uri.substring(contextPath.length());
        } else {
            this.originalPath = this.rootPath + uri;
        }

        this.initEnv();
    }

    // ���������ַ���, �޳�����ע���Լ��滻����б��
    private String filter(String input) {
        return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");
    }

    private void initEnv() throws FileNotFoundException, IOException {
        File file = new File(this.originalPath);

        if (!file.isAbsolute()) {
            file = new File(file.getAbsolutePath());
        }

        this.parentPath = file.getParent();

        String configContent = this.readFile(this.getConfigPath());

        try {
            JSONObject jsonConfig = new JSONObject(configContent);

            this.jsonConfig = jsonConfig;
        } catch (Exception e) {
            this.jsonConfig = null;
        }
    }

    private String readFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();

        try {
            InputStreamReader reader     = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader    bfReader   = new BufferedReader(reader);
            String            tmpContent = null;

            while ((tmpContent = bfReader.readLine()) != null) {
                builder.append(tmpContent);
            }

            bfReader.close();
        } catch (UnsupportedEncodingException e) {

            // ����
        }

        return this.filter(builder.toString());
    }

    // ��֤�����ļ������Ƿ���ȷ
    public boolean valid() {
        return this.jsonConfig != null;
    }

    public JSONObject getAllConfig() {
        return this.jsonConfig;
    }

    private String[] getArray(String key) {
        JSONArray jsonArray = this.jsonConfig.getJSONArray(key);
        String[]  result    = new String[jsonArray.length()];

        for (int i = 0, len = jsonArray.length(); i < len; i++) {
            result[i] = jsonArray.getString(i);
        }

        return result;
    }

    public Map<String, Object> getConfig(int type) {
        Map<String, Object> conf     = new HashMap<String, Object>();
        String              savePath = null;

        switch (type) {
        case ActionMap.UPLOAD_FILE :
            conf.put("isBase64", "false");
            conf.put("maxSize", this.jsonConfig.getLong("fileMaxSize"));
            conf.put("allowFiles", this.getArray("fileAllowFiles"));
            conf.put("fieldName", this.jsonConfig.getString("fileFieldName"));
            savePath = this.jsonConfig.getString("filePathFormat");

            break;

        case ActionMap.UPLOAD_IMAGE :
            conf.put("isBase64", "false");
            conf.put("maxSize", this.jsonConfig.getLong("imageMaxSize"));
            conf.put("allowFiles", this.getArray("imageAllowFiles"));
            conf.put("fieldName", this.jsonConfig.getString("imageFieldName"));
            savePath = this.jsonConfig.getString("imagePathFormat");

            break;

        case ActionMap.UPLOAD_VIDEO :
            conf.put("maxSize", this.jsonConfig.getLong("videoMaxSize"));
            conf.put("allowFiles", this.getArray("videoAllowFiles"));
            conf.put("fieldName", this.jsonConfig.getString("videoFieldName"));
            savePath = this.jsonConfig.getString("videoPathFormat");

            break;

        case ActionMap.UPLOAD_SCRAWL :
            conf.put("filename", ConfigManager.SCRAWL_FILE_NAME);
            conf.put("maxSize", this.jsonConfig.getLong("scrawlMaxSize"));
            conf.put("fieldName", this.jsonConfig.getString("scrawlFieldName"));
            conf.put("isBase64", "true");
            savePath = this.jsonConfig.getString("scrawlPathFormat");

            break;

        case ActionMap.CATCH_IMAGE :
            conf.put("filename", ConfigManager.REMOTE_FILE_NAME);
            conf.put("filter", this.getArray("catcherLocalDomain"));
            conf.put("maxSize", this.jsonConfig.getLong("catcherMaxSize"));
            conf.put("allowFiles", this.getArray("catcherAllowFiles"));
            conf.put("fieldName", this.jsonConfig.getString("catcherFieldName") + "[]");
            savePath = this.jsonConfig.getString("catcherPathFormat");

            break;

        case ActionMap.LIST_IMAGE :
            conf.put("allowFiles", this.getArray("imageManagerAllowFiles"));
            conf.put("dir", this.jsonConfig.getString("imageManagerListPath"));
            conf.put("count", this.jsonConfig.getInt("imageManagerListSize"));

            break;

        case ActionMap.LIST_FILE :
            conf.put("allowFiles", this.getArray("fileManagerAllowFiles"));
            conf.put("dir", this.jsonConfig.getString("fileManagerListPath"));
            conf.put("count", this.jsonConfig.getInt("fileManagerListSize"));

            break;
        }

        conf.put("savePath", savePath);
        conf.put("rootPath", this.rootPath);

        return conf;
    }

    private String getConfigPath() {
        return this.parentPath + File.separator + ConfigManager.configFileName;
    }

    /**
     * ���ù��������칤��
     * @param rootPath ��������·��
     * @param contextPath ������������Ŀ·��
     * @param uri ��ǰ���ʵ�uri
     * @return ���ù�����ʵ������null
     */
    public static ConfigManager getInstance(String rootPath, String contextPath, String uri) {
        try {
            return new ConfigManager(rootPath, contextPath, uri);
        } catch (Exception e) {
            return null;
        }
    }
}



