package com.github.mangelt.azure.upload.invoice.util;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.github.mangelt.sat.services.model.Comprobante;

@Data
@AllArgsConstructor
public class XmlWrapperFile {

	public boolean processed;
	public File file;
	public Comprobante comprobante;
	
}
