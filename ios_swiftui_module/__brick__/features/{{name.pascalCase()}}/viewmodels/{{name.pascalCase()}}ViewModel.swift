import SwiftUI

enum {{name.pascalCase()}}State {
    case idle
    case loading
    case success([{{name.pascalCase()}}])
    case failure(String)
}

class {{name.pascalCase()}}ViewModel: ObservableObject {
    @Published var state: {{name.pascalCase()}}State = .idle
    private let service: {{name.pascalCase()}}Service

    init(service: {{name.pascalCase()}}Service = {{name.pascalCase()}}Service()) {
        self.service = service
    }
    
    func fetchItems() {
        self.state = .loading
        service.fetchItems { [weak self] result in
            switch result {
                case .success(let items):
                    self?.state = .success(items)
                case .failure(let error):
                    self?.state = .failure(error.localizedDescription)
            }
        }
    }
}
