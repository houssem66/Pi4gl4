package tn.esprit.mission.managedbean;

import javax.faces.convert.FacesConverter;

import tn.esprit.mission.entity.MissionPolicy;
import tn.esprit.mission.interfaces.IMissionPolicyService;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "PolicyConvertor")
public class PolicyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ValueExpression vex =
                context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{missionBean}", MissionBean.class);

		MissionBean missions = (MissionBean)vex.getValue(context.getELContext());
        return missions.getPolicy((Integer.valueOf(value)));		
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			return ((MissionPolicy)value).toString();
		} catch (Exception e) {
			return "1";
		} 
		
	}




}