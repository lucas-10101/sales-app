package myprojects.salesapp.configuration.components;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationModelMapper {

    @Bean
    @Primary
    @Qualifier("modelMapper")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();

        var configurations = modelMapper.getConfiguration();
        configurations.setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;
    }

    @Bean
    @Qualifier("modelMapperNoCache")
    public ModelMapper modelMapperWithoutCache() {

        var modelMapper = new ModelMapper();

        var configurations = modelMapper.getConfiguration();
        configurations.setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;
    }
}
