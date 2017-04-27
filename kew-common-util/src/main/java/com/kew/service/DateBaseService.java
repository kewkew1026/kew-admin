package com.kew.service;

import com.kew.model.ModelInfo;
import com.kew.model.ProjectConfig;

import java.util.List;

/**
 * Created by qiudanping on 2017/2/10.
 */
public interface DateBaseService {
    public List<ModelInfo> loadModelInfo(ProjectConfig ccon);
}
