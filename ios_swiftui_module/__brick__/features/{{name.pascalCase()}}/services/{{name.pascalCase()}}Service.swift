import Foundation
import Combine

class {{name.pascalCase()}}Service {
    func fetchItems() -> AnyPublisher<[{{name.pascalCase()}}], Never> {
        let items = [
            {{name.pascalCase()}}(title: "Sample 1", description: "Description 1"),
            {{name.pascalCase()}}(title: "Sample 2", description: "Description 2")
        ]
        return Just(items)
            .eraseToAnyPublisher()
    }
}
