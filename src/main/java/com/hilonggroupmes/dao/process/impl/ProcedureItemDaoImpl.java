package com.hilonggroupmes.dao.process.impl;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.process.ProcedureItemDao;
import com.hilonggroupmes.domain.process.ProcedureItemInfo;

@Repository("procedureItemDao")
public class ProcedureItemDaoImpl extends BaseDaoImpl<ProcedureItemInfo> implements
ProcedureItemDao {

}
