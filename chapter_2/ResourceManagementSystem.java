import java.util.ArrayList;
import java.util.List;

class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use() {
        System.out.println("Using resource: " + name);
    }
}

class ResourcePool {
    private List<Resource> availableResources;
    private List<Resource> allocatedResources;

    public ResourcePool() {
        availableResources = new ArrayList<>();
        allocatedResources = new ArrayList<>();
    }

    public void addResource(Resource resource) {
        availableResources.add(resource);
    }

    public Resource allocateResource() {
        if (availableResources.isEmpty()) {
            System.out.println("No available resources!");
            return null;
        }
        Resource resource = availableResources.remove(availableResources.size() - 1);
        allocatedResources.add(resource);
        return resource;
    }

    public void deallocateResource(Resource resource) {
        if (allocatedResources.remove(resource)) {
            availableResources.add(resource);
        } else {
            System.out.println("Resource not allocated!");
        }
    }

    public int availableCount() {
        return availableResources.size();
    }
}

public class ResourceManagementSystem {
    public static void main(String[] args) {
        ResourcePool pool = new ResourcePool();
        pool.addResource(new Resource("Resource 1"));
        pool.addResource(new Resource("Resource 2"));
        pool.addResource(new Resource("Resource 3"));

        System.out.println("Available resources: " + pool.availableCount());
        
        Resource resource1 = pool.allocateResource();
        if (resource1 != null) {
            resource1.use();
        }

        System.out.println("Available resources: " + pool.availableCount());
        pool.deallocateResource(resource1);
        System.out.println("Available resources after deallocation: " + pool.availableCount());
    }
}
// This program for allocation and deallocation 