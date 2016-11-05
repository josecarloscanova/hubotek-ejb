package org.hubotek.service.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import org.hubotek.service.Service;

@Local
public interface LocalService extends Service , Serializable{
}
