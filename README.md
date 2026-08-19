## HDFC Life Policy Console

# HDFC Life Policy Console

A small Java console application demonstrating common design patterns used in an insurance policy & claim domain: factory for policy creation, a store for policy/claim management, strategy-based premium calculation, observer-based claim notifications, and custom exceptions for validation and errors. The project is intended as a learning/demo application rather than a production system.

## Stack
- Language(s): Java (single-language repository)
- Framework / runtime: Plain Java (javac/java)
- Notable patterns & concepts: Factory, Strategy, Observer, Builder, Singleton (enum), PriorityQueue, custom exceptions

## What’s included / Key components
- AppConfig (singleton enum) — application constants (company name, max claim amount).
- PolicyFactory — creates Policy instances from a policy type.
- PolicyStore — in-memory store for policies and claims; supports lookup, printing, and priority-based claim listing.
- PremiumCalculator + Strategy implementations (e.g., ULIP_Strategy_Impl) — decoupled premium calculation.
- Claim, Claim.Builder, ClaimStatus, Urgency — claim model with builder pattern and status/urgency enums.
- ClaimService — files claims, updates status, integrates with ClaimEventPublisher.
- ClaimEventPublisher + Observers (InAppNotifier, BranchLetterNotifier) — observer pattern for notifications on claim events.
- Custom exceptions — PolicyServiceException and specialized exceptions for domain errors.
- Demo (src/com/hdfclife/Demo.java) — sample main that wires components together and demonstrates features.

## How it’s organized
Top-level relevant tree (folders/files that matter):

