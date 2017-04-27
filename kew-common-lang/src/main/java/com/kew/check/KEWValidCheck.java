package com.kew.check;

import com.kew.annotation.KEWValid;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static net.sf.oval.Validator.getCollectionFactory;

/**
 * Created by qiudanping on 2017/2/8.
 */
public class KEWValidCheck extends AbstractAnnotationCheck<KEWValid> {

    private Logger logger = LoggerFactory.getLogger(KEWValidCheck.class);

    private static final long serialVersionUID = -7845423901320035999L;

    private String regModel;
    private boolean required;
    private int min;
    private int max;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getRegModel() {
        return regModel;
    }

    public void setRegModel(String regModel) {
        this.regModel = regModel;
        requireMessageVariablesRecreation();
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public void configure(KEWValid constraintAnnotation) {
        super.configure(constraintAnnotation);
        setRegModel(constraintAnnotation.regModel());
        setRequired(constraintAnnotation.required());
        setMin(constraintAnnotation.min());
        setMax(constraintAnnotation.max());
        setName(constraintAnnotation.name());
    }

    @Override
    public void setMessage(String message) {
        if(message!=null&&!"".equals(message)){
            super.setMessage(message);
        }else{
            super.setMessage("com.dsa.message.error.model");
        }
    }

    @Override
    protected Map<String, String> createMessageVariables(){
        final Map<String, String> messageVariables = getCollectionFactory().createMap(1);
        messageVariables.put("max", Integer.toString(max));
        messageVariables.put("min", Integer.toString(min));
        return messageVariables;
    }

    public boolean isSatisfied(Object validatedObject, Object valueToValidate,OValContext context, Validator validator) {
        try {
            if(valueToValidate==null||"".equals(valueToValidate.toString())){
                if(required||min>0){
                    setMessage(Constants.loadMsgKeyBy(Constants.NOT_EMPTY));
                    return false;
                }
                return true;
            }

            if(!Constants.XSS.equals(regModel)){
                String modelReg = Constants.loadRegBy(regModel);
                setMessage(Constants.loadMsgKeyBy(regModel));

                boolean isformate = valueToValidate.toString().matches(modelReg);

                if(required&&!isformate){
                    return false;
                }else if(!isformate){
                    logger.warn("Valid Failed:[value="+valueToValidate+",regModel="+regModel+"]");
                }
            }

            if(max>=min&&(max!=Integer.MAX_VALUE||min!=0)){
                setMessage("net.sf.oval.constraint.Size.violated");
                if(!valueToValidate.toString().matches("[\\s\\S]{"+getMin()+","+getMax()+"}")){
                    return false;
                };
            }

//			modelReg = Constants.loadRegBy(Constants.XSS);
//			setMessage(Constants.loadMsgKeyBy(Constants.XSS));
//			return !valueToValidate.toString().matches(modelReg);

        } catch (Exception e) {
            logger.error("验证",e);
        }
        return true;
    }
}
