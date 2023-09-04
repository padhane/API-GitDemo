package POJOLayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repository {
	private String name;
	private String description;
	private String homepage;
	private boolean has_issues;
	private boolean has_projects;
	private boolean has_wiki;
}
