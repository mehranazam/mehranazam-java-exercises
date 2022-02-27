package learn.solar.domain;

import learn.solar.data.PanelRepository;
import learn.solar.data.PanelRepositoryTestDouble;

public class PanelServiceTest {
    PanelService service = new PanelService(new PanelRepositoryTestDouble());


}
