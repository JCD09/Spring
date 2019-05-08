package NewsFeed.NewsFeed.Messages;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Sources{

    public String status;
    public List<ExtendedSource> sources;
}

