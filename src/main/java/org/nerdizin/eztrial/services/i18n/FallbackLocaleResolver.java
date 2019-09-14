package org.nerdizin.eztrial.services.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Service
public class FallbackLocaleResolver extends AcceptHeaderLocaleResolver
        implements LocaleResolver {

    private static final Logger LOG = LoggerFactory.getLogger(FallbackLocaleResolver.class);

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = super.resolveLocale(httpServletRequest);
        LOG.info("GOT LOCALE: " + locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse,
                          Locale locale) {

    }
}
