/**
 * Created by Jakub on 2017-11-14.
 */

package Graph;

public class GraphRunner {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("VIZ-5280","Update DMP to load content by content ID");
        graph.addVertex("VIZ-5321","Image Component");
        graph.addVertex("VIZ-5288","Header Navigation");
        graph.addVertex("VIZ-5289","Footer Navigation");
        graph.addVertex("VIZ-5324","Combobox Component");
        graph.addVertex("VIZ-5339","Social Links Component");
        graph.addVertex("VIZ-5340","Contact Us Footer Component");
        graph.addVertex("VIZ-5323","Video Component");
        graph.addVertex("VIZ-5322","VT Component");
        graph.addVertex("VIZ-5290","Media Carousel Component");
        graph.addVertex("VIZ-5291","Home Page wrapper component");
        graph.addVertex("VIZ-5292","Custom html component");
        graph.addVertex("VIZ-5293","Booking Component");
        graph.addVertex("VIZ-5325","Date Range Picker Component");
        graph.addVertex("VIZ-5326","Stepper Component");
        graph.addVertex("VIZ-5327","GA Tracking Implementation");
        graph.addVertex("VIZ-5299","Feature Story Page Component wrapper - with text");
        graph.addVertex("VIZ-5300","Carousel in Modal with a dock");
        graph.addVertex("VIZ-5330","Grid Item Card Component (Image, VR, Video)");
        graph.addVertex("VIZ-5329","Tabs Component");
        graph.addVertex("VIZ-5301","Tile Grid");
        graph.addVertex("VIZ-5328","Grouped Story Wrapper Component");
        graph.addVertex("VIZ-5331","Grid Item Card Component (Offer)");
        graph.addVertex("VIZ-5302","Offer story Page Component wrapper - with text");
        graph.addVertex("VIZ-5333","Booking Dates Component");
        graph.addVertex("VIZ-5303","Offer Item Page Component");
        graph.addVertex("VIZ-5332","Grid Item Card Component (Room) Story");
        graph.addVertex("VIZ-5304","Room story Page Component wrapper - with text");
        graph.addVertex("VIZ-5305","Room Item Page Component");
        graph.addVertex("VIZ-5337","Room Information Component");
        graph.addVertex("VIZ-5338","Room Amenities Component");
        graph.addVertex("VIZ-5306","Selecting theme from theme selection");
        graph.addVertex("VIZ-5307","Website Settings implementation in Publisher");
        graph.addVertex("VIZ-5308","Text Page Wrapper component");
        graph.addVertex("VIZ-5309","Policies Page (Identical to Text only page)");
        graph.addVertex("VIZ-5310","Contact Us Page Wrapper component");
        graph.addVertex("VIZ-5311","Reviews Page (Trip Advisor Component)");
        graph.addVertex("VIZ-5334","Map Component");
        graph.addVertex("VIZ-5335","Phone Numbers Component Story");
        graph.addVertex("VIZ-5336","Address Component");
        graph.addVertex("VIZ-5281","Update Webuilder Server to reconize the new theme");
        graph.addVertex("VIZ-5283","Update Webuilder Config and page model");
        graph.addVertex("VIZ-5312","Website serving Story");
        graph.addVertex("VIZ-5313","Theme Customization");
        graph.addVertex("VIZ-5314","Website Preview (Preview button to open in new tab)");
        graph.addVertex("VIZ-5315","Website Publish (Go Live)");
        graph.addVertex("VIZ-5316","Multiple Stories on a page");
        graph.addVertex("VIZ-5318","Layout options");

        graph.addDependency("VIZ-5325", "VIZ-5293");
        graph.addDependency("VIZ-5326", "VIZ-5293");
        graph.addDependency("VIZ-5324", "VIZ-5293");
        graph.addDependency("VIZ-5327", "VIZ-5293");
        graph.addDependency("VIZ-5283", "VIZ-5293");

        graph.addDependency("VIZ-5281", "VIZ-5312");
        graph.addDependency("VIZ-5283", "VIZ-5312");
        graph.addDependency("VIZ-5283", "VIZ-5314");
        graph.addDependency("VIZ-5283", "VIZ-5315");
        graph.addDependency("VIZ-5281", "VIZ-5314");
        graph.addDependency("VIZ-5281", "VIZ-5315");
        graph.addDependency("VIZ-5280", "VIZ-5316");
        graph.addDependency("VIZ-5340", "VIZ-5289");

        graph.addDependency("VIZ-5321", "VIZ-5288");
        graph.addDependency("VIZ-5324", "VIZ-5289");
        graph.addDependency("VIZ-5339", "VIZ-5289");

        graph.addDependency("VIZ-5323", "VIZ-5290");
        graph.addDependency("VIZ-5322", "VIZ-5290");
        graph.addDependency("VIZ-5321", "VIZ-5290");
        graph.addDependency("VIZ-5290", "VIZ-5300");

        graph.addDependency("VIZ-5330", "VIZ-5301");
        graph.addDependency("VIZ-5329", "VIZ-5328");
        graph.addDependency("VIZ-5301", "VIZ-5328");
        graph.addDependency("VIZ-5333", "VIZ-5303");
        graph.addDependency("VIZ-5332", "VIZ-5304");

        graph.addDependency("VIZ-5338", "VIZ-5305");
        graph.addDependency("VIZ-5337", "VIZ-5305");

        graph.addDependency("VIZ-5331", "VIZ-5302");
        graph.addDependency("VIZ-5328", "VIZ-5318");

        graph.addDependency("VIZ-5336", "VIZ-5310");
        graph.addDependency("VIZ-5335", "VIZ-5310");
        graph.addDependency("VIZ-5334", "VIZ-5310");


        System.out.println(graph.toString());

        graph.BFS();

        System.out.println(graph.topologicalSort());
    }
}
