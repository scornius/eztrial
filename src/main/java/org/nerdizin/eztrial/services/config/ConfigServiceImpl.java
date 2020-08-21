package org.nerdizin.eztrial.services.config;

import org.springframework.stereotype.Service;

import static org.nerdizin.eztrial.util.Constants.*;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Override
    public int getUserListPageSize() {
        return DEFAULT_USERLIST_PAGE_SIZE;
    }

}
