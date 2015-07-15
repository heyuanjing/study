package com.admin;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaExportTools {

	public static void main(String[] args) throws Exception {
		new SchemaExport(new Configuration().configure("../../../resources/hibernate.cfg.xml")).create(true, true);
	}
}
