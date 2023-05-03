package com.myapp.spring_demo.factory;

import com.myapp.spring_demo.adapter.IExternalServiceAdapter;
import com.myapp.spring_demo.model.IntegrationType;
import com.myapp.spring_demo.service.impl.DummyServiceOneImpl;
import com.myapp.spring_demo.service.impl.DummyServiceTwoImpl;

public class ExternalServiceFactory {

    public static IExternalServiceAdapter getApiService(IntegrationType integrationType) {
        switch (integrationType) {
            case DUMMY_SERVICE_ONE -> {
                return new DummyServiceOneImpl();
            }

            case DUMMY_SERVICE_TWO -> {
                return new DummyServiceTwoImpl();
            }
        }
        return null;
    }

}
