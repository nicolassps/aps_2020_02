package br.com.alpoo.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration
public class RestConfig implements WebMvcRegistrations {
	
	public class PrefixedApiRequestHandler extends RequestMappingHandlerMapping {

	    private final String prefix;

	    private final String[] prefixedPackages;

	    public PrefixedApiRequestHandler(final String prefix, final String... packages) {
	        super();
	        this.prefix = prefix;
	        this.prefixedPackages = packages.clone();

	    }

	    @Override
	    protected RequestMappingInfo getMappingForMethod(final Method method, final Class<?> handlerType) {

	        RequestMappingInfo info = super.getMappingForMethod(method, handlerType);
	        if (info == null) {
	            return null;
	        }

	        for (final String packageRef : prefixedPackages) {
	            if (handlerType.getPackage().getName().contains(packageRef)) {
	                info = createPrefixedApi().combine(info);

	                return info;
	            }
	        }
	        return info;
	    }

	    private RequestMappingInfo createPrefixedApi() {
	        String[] patterns = new String[prefix.length()];
	        for (int i = 0; i < patterns.length; i++) {
	            patterns[i] = prefix;
	        }

	        return new RequestMappingInfo(
	                new PatternsRequestCondition(patterns,
	                        getUrlPathHelper(),
	                        getPathMatcher(),
	                        useSuffixPatternMatch(),
	                        useTrailingSlashMatch(),
	                        getFileExtensions()),
	                new RequestMethodsRequestCondition(),
	                new ParamsRequestCondition(),
	                new HeadersRequestCondition(),
	                new ConsumesRequestCondition(),
	                new ProducesRequestCondition(),
	                null);
	    }
	}

    @Value("/api")
    private String apiPrefix;

    @Value("br.com.alpoo.rest") 
    private String[] prefixedPackages;

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new PrefixedApiRequestHandler(apiPrefix,prefixedPackages);
    }
}
