package com.jcs.goboax.aulavirtual.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest
{
    @Before
    public void setup() throws Exception
    {
        //empty
    }

    @Test
    public void simple() throws Exception
    {
        List<String> myList = new ArrayList<String>();
        myList.add("pdf");
        myList.add("doc");
        myList.add("ppt");
        myList.add("docx");
        String myResult = Utils.convertListExtensionsToAcceptString(myList);
        String myResultExpected = ".pdf,.doc,.ppt,.docx";
        Assert.assertEquals(myResultExpected, myResult);
    }

}
