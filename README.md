# 📦 Hy-Tech Smart Logistics Engine (Core Java)

A robust, object-oriented logistics and dynamic pricing engine built with Core Java. This project demonstrates advanced OOP principles, design patterns, and clean architecture without relying on external frameworks.

## 🚀 Key Technologies & Concepts

* **Core Java (Java 11+)**: Pure Java implementation focusing on clean code and robust architecture.
* **Design Patterns**: Implemented the `Strategy Pattern` via `TransportStrategy` interface for dynamic shipping cost calculation (Air, Land) to eliminate complex if-else structures and ensure the Open/Closed Principle.
* **Advanced OOP Architecture**:
  * **Abstraction & Polymorphism**: Loose coupling using interfaces to process diverse transport methods seamlessly.
  * **Encapsulation**: Secure data models (`Customer`, `Shipment`) preventing unauthorized state modification.
  * **Enums**: Strongly typed state management (`CargoStatus`, `CustomerType`) integrating custom fields and default discount multipliers.
