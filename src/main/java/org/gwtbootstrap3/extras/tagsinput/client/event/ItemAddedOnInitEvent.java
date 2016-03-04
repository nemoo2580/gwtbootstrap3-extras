package org.gwtbootstrap3.extras.tagsinput.client.event;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.event.shared.GwtEvent;

/**
 * During initialization, pre-defined tags being added will
 * cause {@link ItemAddedOnInitEvent} to be triggered.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class ItemAddedOnInitEvent extends GwtEvent<ItemAddedOnInitHandler> {
    // TODO Add Item as payload to event.
    
    private static Type<ItemAddedOnInitHandler> TYPE;

    /**
     * Fires a tagsinput itemAddedOnInit event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasItemAddedOnInitHandlers source) {
        if (TYPE != null) {
            ItemAddedOnInitEvent event = new ItemAddedOnInitEvent();
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ItemAddedOnInitHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ItemAddedOnInitHandler>();
        }
        return TYPE;
    }


    @Override
    public Type<ItemAddedOnInitHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ItemAddedOnInitHandler handler) {
        handler.onItemAddedOnInit(this);
    }

    /**
     * Creates a tagsinput addItemOnInit event.
     */
    protected ItemAddedOnInitEvent() {}
}