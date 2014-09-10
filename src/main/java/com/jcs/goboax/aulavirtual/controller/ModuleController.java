package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.util.FlashMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;

@Controller
public class ModuleController
{
    private static final Logger LOG = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FlashMessage flashMessage;

    @Autowired
    private ConversionService conversionService;

}
