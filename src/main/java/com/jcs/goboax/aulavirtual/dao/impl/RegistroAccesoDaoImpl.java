/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcs.goboax.aulavirtual.dao.impl;

import com.jcs.goboax.aulavirtual.dao.api.RegistroAccesoDao;
import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegistroAccesoDaoImpl
        extends BaseDaoImpl<Integer, RegistroAcceso>
        implements RegistroAccesoDao
{

    private final static Logger LOG = LoggerFactory.getLogger(RegistroAccesoDaoImpl.class);

}
