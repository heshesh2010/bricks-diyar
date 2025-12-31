struct {{name.pascalCase()}}: Identifiable, Codable {
    let id: UUID = UUID()
    // Add your model properties here
    var title: String
    var description: String
}
