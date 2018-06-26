package br.com.springboot.error;

import javax.annotation.Generated;

public class ValidationErrorDetails extends ErrorDetail {
	private String field;
	private String fieldMessage;

	public String getField() {
		return field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	@Generated("SparkTools")
	private ValidationErrorDetails(Builder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.detail = builder.detail;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
		this.field = builder.field;
		this.fieldMessage = builder.fieldMessage;
	}

	private ValidationErrorDetails() {
	}

	/**
	 * Creates builder to build {@link ResourceNotFoundDetails}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ResourceNotFoundDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;
		private String field;
		private String fieldMessage;

		private Builder() {
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public Builder withfield(String field) {
			this.field = field;
			return this;
		}

		public Builder withfieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}
	}

}
