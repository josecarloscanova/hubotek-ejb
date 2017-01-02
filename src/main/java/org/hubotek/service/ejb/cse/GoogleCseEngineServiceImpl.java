package org.hubotek.service.ejb.cse;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.cse.CseEngine;
import org.hubotek.service.data.CseEngineService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;

@Stateless
public class GoogleCseEngineServiceImpl implements GoogleCseEngineService{

	@Inject @Named("cseEngineService")
	CseEngineService cseEngineService;
	
	Function <GoogleCustomSearchEngine , CseEngine> toModel = (t) ->  new CseEngine(t.getIdentification(), t.getDescription(), t.getDateCreated());
	
	Function <CseEngine ,GoogleCustomSearchEngine > toView = (t) ->  new GoogleCustomSearchEngine(t.getIdentification(), t.getDescription(), new Date(Optional.ofNullable(t.getDateCreated()).orElse(new Date()).getTime()));
	
	private static final long serialVersionUID = 6125021310602570054L;

	@Override
	public GoogleCustomSearchEngine findByValue(String identification) {
		return toView.apply(cseEngineService.find(identification));
	}

	@Override
	public List<GoogleCustomSearchEngine> getEngines() {
		return cseEngineService.rangeOf(0, 100).stream().map(t -> toView.apply(t)).collect(Collectors.toList());
	}

	@Override
	public void saveEngine(GoogleCustomSearchEngine googleCustomSearchEngine) {
		cseEngineService.save(toModel.apply(googleCustomSearchEngine));
	}

	@Override
	public void delete(GoogleCustomSearchEngine gcse) {
		cseEngineService.delete(toModel.apply(gcse));
	}
	
	@Override
	public void delete() {
		cseEngineService.deleteAll();
	}

}
