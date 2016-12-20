package org.hubotek.service.data;

import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.service.DataBaseService;

@Named("cseEngineService")
public class CseEngineService  extends DataBaseService<CseKey , Long>{
}
