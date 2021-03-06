package com.gss.student.webservice;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 3/5/2015 3:54:30 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class DailyAbsents implements KvmSerializable {
    
    public int mDay;
    public VectorInt32 absentPeriods;
    
    public DailyAbsents(){}
    
    public DailyAbsents(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("mDay"))
        {
            Object obj = soapObject.getProperty("mDay");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                mDay = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                mDay = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("AbsentPeriods"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("AbsentPeriods");
            absentPeriods = new VectorInt32(j);
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return mDay;
            case 1:
                return absentPeriods;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 2;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "mDay";
                break;
            case 1:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "AbsentPeriods";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
