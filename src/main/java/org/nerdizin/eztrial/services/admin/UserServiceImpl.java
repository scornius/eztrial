package org.nerdizin.eztrial.services.admin;

import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.services.config.ConfigService;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.converter.UserFilterConverter;
import org.nerdizin.eztrial.web.data.UsersSortableDataProvider;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private ConfigService configService;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserConverter userConverter;

    @Inject
    private UserFilterConverter userFilterConverter;


    @Override
    public UsersSortableDataProvider getSortableDataProvider() {
        return new UsersSortableDataProvider(
                configService.getUserListPageSize(),
                userRepository,
                userConverter,
                userFilterConverter
        );
    }
}
